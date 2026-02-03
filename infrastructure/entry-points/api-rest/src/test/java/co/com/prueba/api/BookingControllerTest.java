package co.com.prueba.api;

import co.com.prueba.api.controller.ApiResponse;
import co.com.prueba.model.Bookings;
import co.com.prueba.model.Flights;
import co.com.prueba.model.Tickets;
import co.com.prueba.model.Users;
import co.com.prueba.usecase.BookingUseCase;
import co.com.prueba.usecase.FlightUseCase;
import co.com.prueba.usecase.TicketUseCase;
import co.com.prueba.usecase.UserUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookingControllerTest {

    @Mock
    private BookingUseCase bookingUseCase;

    @Mock
    private TicketUseCase ticketUseCase;

    @Mock
    private FlightUseCase flightUseCase;

    @Mock
    private UserUseCase userUseCase;

    @InjectMocks
    private BookingController bookingController;

    @Test
    void testCreateBooking(){
        Bookings bookings = new Bookings();
        bookings.setUserId(1L);
        bookings.setFlightId(1L);
        bookings.setTicketId(1L);
        bookings.setNombre("User Test");
        bookings.setBookingDate(LocalDateTime.now());

        Users users = new Users();
        users.setUserId(1L);
        users.setNombre("User Test");

        Tickets tickets = new Tickets();

        Flights flights = new Flights();

        when(userUseCase.buscarPorId(1L)).thenReturn(Optional.of(users));
        when(ticketUseCase.buscarPorId(anyLong())).thenReturn(Optional.of(tickets));
        when(flightUseCase.buscarPorId(anyLong())).thenReturn(Optional.of(flights));
        when(bookingUseCase.reservar(any(Bookings.class))).thenReturn(bookings);

        ResponseEntity<ApiResponse<Bookings>> response = bookingController.guardar(bookings);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("User Test", response.getBody().getData().getNombre());
        verify(bookingUseCase, times(1)).reservar(bookings);
    }

    @Test
    void testGetBookingId(){
        Bookings bookings = new Bookings();
        bookings.setBookingId(1L);
        when(bookingUseCase.listarPorId(1L)).thenReturn(Optional.of(bookings));

        ResponseEntity<ApiResponse<Bookings>> response = bookingController.listarPorId(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1L, response.getBody().getData().getBookingId());
    }

}