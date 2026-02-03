package co.com.prueba.jpa;

import co.com.prueba.jpa.repositories.BookingJpaRepository;
import co.com.prueba.jpa.repositories.FlightJpaRepository;
import co.com.prueba.jpa.repositories.TicketJpaRepository;
import co.com.prueba.jpa.repositories.UserJpaRepository;
import co.com.prueba.model.Bookings;
import co.com.prueba.model.Flights;
import co.com.prueba.model.Tickets;
import co.com.prueba.model.Users;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookingRepositoryAdapterTest {

    @Mock
    private BookingJpaRepository bookingJpaRepository;

    @Mock
    private FlightJpaRepository flightJpaRepository;

    @Mock
    private TicketJpaRepository ticketJpaRepository;

    @Mock
    private UserJpaRepository userJpaRepository;

    @InjectMocks
    private BookingRepositoryAdapter bookingRepositoryAdapter;

    @InjectMocks
    private FlightRepositoryAdapter flightRepositoryAdapter;

    @InjectMocks
    private TicketRepositoryAdapter ticketRepositoryAdapter;

    @InjectMocks
    private UserRepositoryAdapter userRepositoryAdapter;

    @Test
    void testSaveBooking(){
        Bookings bookings = new Bookings();
        bookings.setUserId(1L);
        bookings.setFlightId(1L);
        bookings.setTicketId(1L);
        bookings.setNombre("User Test");
        bookings.setBookingDate(LocalDateTime.now());

        when(bookingJpaRepository.save(any(Bookings.class))).thenReturn(bookings);

        Bookings result = bookingRepositoryAdapter.save(bookings);

        assertNotNull(result);
        assertEquals("User Test", result.getNombre());
        verify(bookingJpaRepository, times(1)).save(bookings);
    }

    @Test
    void testFindById(){
        Bookings bookings = new Bookings();
        bookings.setBookingId(1L);
        when(bookingJpaRepository.findById(1L)).thenReturn(Optional.of(bookings));

        Optional<Bookings> result = bookingRepositoryAdapter.findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.get().getBookingId());
    }

    @Test
    void testGetAll(){
        List<Bookings> bookings = new ArrayList<>();
        when(bookingJpaRepository.findAll()).thenReturn(bookings);

        List<Bookings> result = bookingRepositoryAdapter.findAll();

        assertNotNull(result);
    }

    @Test
    void testSaveFlight(){
        Flights flights = new Flights();

        flights.setFlightDate(LocalDateTime.now());
        flights.setFlightId(1L);
        flights.setDescripcion("Test");

        when(flightJpaRepository.save(any(Flights.class))).thenReturn(flights);

        Flights result = flightRepositoryAdapter.save(flights);

        assertNotNull(result);
        assertEquals("Test", result.getDescripcion());
        verify(flightJpaRepository, times(1)).save(flights);
    }

    @Test
    void testFlightFindById(){
        Flights flights = new Flights();
        flights.setFlightId(1L);

        when(flightJpaRepository.findById(1L)).thenReturn(Optional.of(flights));

        Optional<Flights> result = flightRepositoryAdapter.findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.get().getFlightId());
    }

    @Test
    void testSaveTicket(){
        Tickets tickets = new Tickets();

        tickets.setTicketId(1L);

        when(ticketJpaRepository.save(any(Tickets.class))).thenReturn(tickets);

        Tickets result = ticketRepositoryAdapter.save(tickets);

        assertNotNull(result);
        assertEquals(1L, result.getTicketId());
        verify(ticketJpaRepository, times(1)).save(tickets);
    }

    @Test
    void testTickettFindById(){
        Tickets tickets = new Tickets();
        tickets.setTicketId(1L);

        when(ticketJpaRepository.findById(1L)).thenReturn(Optional.of(tickets));

        Optional<Tickets> result = ticketRepositoryAdapter.findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.get().getTicketId());
    }

    @Test
    void testSaveUser(){
        Users users = new Users();

        users.setUserId(1L);
        users.setNombre("User Test");

        when(userJpaRepository.save(any(Users.class))).thenReturn(users);

        Users result = userRepositoryAdapter.save(users);

        assertNotNull(result);
        assertEquals(1L, result.getUserId());
        verify(userJpaRepository, times(1)).save(users);
    }

    @Test
    void testUsertFindById(){
        Users users = new Users();
        users.setUserId(1L);

        when(userJpaRepository.findById(1L)).thenReturn(Optional.of(users));

        Optional<Users> result = userJpaRepository.findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.get().getUserId());
    }

}