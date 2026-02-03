package co.com.prueba.usecase;

import co.com.prueba.model.Bookings;
import co.com.prueba.model.gateways.BookingRepository;
import co.com.prueba.model.gateways.FlightRepository;
import co.com.prueba.model.gateways.TicketRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class BookingUseCase {

    private final BookingRepository bookingRepository;

    public BookingUseCase(BookingRepository bookingRepository, FlightRepository flightRepository, TicketRepository ticketRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Bookings reservar(Bookings bookings){
        bookings.setBookingDate(LocalDateTime.now());
        return bookingRepository.save(bookings);
    }

    public void cancelar(Long bookingId){
        bookingRepository.deleteById(bookingId);
    }

    public List<Bookings> listarPorUsuario(Long userId){
        return bookingRepository.findByUserId(userId);
    }

    public List<Bookings> listarTodos(){
        return bookingRepository.findAll();
    }

    public Optional<Bookings> listarPorId(Long bookingId){
        return bookingRepository.findById(bookingId);
    }

    public Boolean existById(Long bookingId){
        return bookingRepository.existById(bookingId);
    }

}
