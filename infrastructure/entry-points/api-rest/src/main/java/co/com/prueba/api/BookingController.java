package co.com.prueba.api;

import co.com.prueba.api.controller.ApiResponse;
import co.com.prueba.api.exception.NotFoundException;
import co.com.prueba.model.Bookings;
import co.com.prueba.model.Flights;
import co.com.prueba.model.Tickets;
import co.com.prueba.model.Users;
import co.com.prueba.usecase.BookingUseCase;
import co.com.prueba.usecase.FlightUseCase;
import co.com.prueba.usecase.TicketUseCase;
import co.com.prueba.usecase.UserUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("airline/bookings")
@Slf4j
public class BookingController {

    private final BookingUseCase bookingUseCase;
    private final FlightUseCase flightUseCase;
    private final TicketUseCase ticketUseCase;
    private final UserUseCase userUseCase;

    public BookingController(BookingUseCase bookingUseCase, FlightUseCase flightUseCase, TicketUseCase ticketUseCase, UserUseCase userUseCase) {
        this.bookingUseCase = bookingUseCase;
        this.flightUseCase = flightUseCase;
        this.ticketUseCase = ticketUseCase;
        this.userUseCase = userUseCase;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Bookings>> guardar(
            @RequestBody Bookings bookings){

        Users users = userUseCase.buscarPorId(bookings.getUserId()).
                orElseThrow(() -> new NotFoundException("Usuario no existe"));

        Flights flights = flightUseCase.buscarPorId(bookings.getFlightId()).
                orElseThrow(() -> new NotFoundException("Vuelo no existe"));

        Tickets tickets = ticketUseCase.buscarPorId(bookings.getTicketId()).
                orElseThrow(() -> new NotFoundException("Tiquete no existe"));

        Bookings result = bookingUseCase.reservar(bookings);

        log.info("Reserva Creada con Id: {}", result.getBookingId());

        return ResponseEntity.status(201).body(
                new ApiResponse<>(result,201,"Reserva creada")
        );
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<ApiResponse<Void>> cancelar(@PathVariable("bookingId") Long bookingId){

        if(!bookingUseCase.existById(bookingId)){
            throw new NotFoundException("Reserva no encontrada");
        }

        bookingUseCase.cancelar(bookingId);

        log.info("Reserva Cancelada con Id: {}", bookingId);

        return ResponseEntity.ok(new ApiResponse<>(null,200,"Reserva cancelada"));
    }

    @GetMapping("/usuario/{userId}")
    public ResponseEntity<ApiResponse<List<Bookings>>> listarPorUsuario(
            @PathVariable("userId") Long userId
    ){
        List<Bookings> reservas = bookingUseCase.listarPorUsuario(userId);

        log.debug("Reserva Encontrada: {} con userId: {}",reservas, userId);

        return ResponseEntity.ok(new ApiResponse<>(reservas,200,"Reservas del usuario"));
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<ApiResponse<Bookings>> listarPorId(
            @PathVariable("bookingId") Long bookingId
    ){
        Bookings reserva = bookingUseCase.listarPorId(bookingId).
                orElseThrow(() -> new NotFoundException("Reserva no existe"));

        log.info("Reserva Encontrada con Id: {}",bookingId);

        return ResponseEntity.ok(new ApiResponse<>(reserva,200,"Reserva por ID"));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Bookings>>> listarTodos(){
        List<Bookings> reserva = bookingUseCase.listarTodos();

        if(reserva.isEmpty()){
            throw new NotFoundException("No existen Reservas");
        }

        return ResponseEntity.ok(new ApiResponse<>(reserva,200,"Listado de reservas"));
    }
}
