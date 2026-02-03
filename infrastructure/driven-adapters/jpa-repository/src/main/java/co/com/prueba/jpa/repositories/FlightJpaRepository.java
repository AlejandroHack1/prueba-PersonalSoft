package co.com.prueba.jpa.repositories;

import co.com.prueba.model.Flights;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightJpaRepository extends JpaRepository<Flights, Long> {

    List<Flights> findByFlightDate(LocalDateTime flightDate);
}
