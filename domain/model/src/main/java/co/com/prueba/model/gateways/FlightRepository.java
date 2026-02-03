package co.com.prueba.model.gateways;

import co.com.prueba.model.Bookings;
import co.com.prueba.model.Flights;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightRepository {

    Flights save(Flights flights);
    //Flights updateDate(Long flightId, LocalDateTime newDate);
    List<Flights> findByDate(LocalDateTime flightDate);
    Optional<Flights> findById(Long flightId);
    List<Flights> findAll();
}
