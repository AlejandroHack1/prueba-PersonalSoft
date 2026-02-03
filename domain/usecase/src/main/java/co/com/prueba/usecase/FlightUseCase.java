package co.com.prueba.usecase;

import co.com.prueba.model.Flights;
import co.com.prueba.model.gateways.FlightRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class FlightUseCase {

    private final FlightRepository flightRepository;

    public FlightUseCase(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Flights guardar(Flights flights){
        return flightRepository.save(flights);
    }

    /*public Flights actualizar(Long flightId, LocalDateTime newDate){
        if(newDate.isBefore(LocalDateTime.now())){
            throw new BadRequestException("La fecha no puede ser anterior a la actual");
        }

        return flightRepository.updateDate(flightId, newDate);
    }*/

    public List<Flights> buscarFecha(LocalDateTime flightDate){
        return flightRepository.findByDate(flightDate);
    }

    public Optional<Flights> buscarPorId(Long flightId){
        return flightRepository.findById(flightId);
    }

    public List<Flights> listarTodos(){
        return flightRepository.findAll();
    }
}
