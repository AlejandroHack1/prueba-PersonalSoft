package co.com.prueba.model.gateways;

import co.com.prueba.model.Bookings;
import co.com.prueba.model.Flights;
import co.com.prueba.model.Tickets;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface BookingRepository {

    Bookings save(Bookings bookings);
    Optional<Bookings> findById(Long bookingId);
    boolean existById(Long bookingId);
    List<Bookings> findAll();
    List<Bookings> findByUserId(Long userId);
    void deleteById(Long bookingId);
}
