package co.com.prueba.jpa;

import co.com.prueba.api.exception.NotFoundException;
import co.com.prueba.jpa.repositories.FlightJpaRepository;
import co.com.prueba.model.Bookings;
import co.com.prueba.model.Flights;
import co.com.prueba.model.gateways.FlightRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class FlightRepositoryAdapter implements FlightRepository {

    private final FlightJpaRepository flightRepository;

    public FlightRepositoryAdapter(FlightJpaRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public Flights save(Flights flights) {
        return flightRepository.save(flights);
    }

    /*@Override
    public Flights updateDate(Long flightId, LocalDateTime newDate) {
        Flights flights = flightRepository.findById(flightId).
                orElseThrow(() -> new NotFoundException("Vuelo no existe"));

        flights.setFlightDate(newDate);
        return flightRepository.save(flights);
    }*/

    @Override
    public List<Flights> findByDate(LocalDateTime flightDate) {
        return flightRepository.findByFlightDate(flightDate);
    }

    @Override
    public Optional<Flights> findById(Long flightId) {
        return flightRepository.findById(flightId);
    }

    @Override
    public List<Flights> findAll() {
        return flightRepository.findAll();
    }
}
