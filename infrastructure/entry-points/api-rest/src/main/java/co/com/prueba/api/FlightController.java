package co.com.prueba.api;

import co.com.prueba.api.controller.ApiResponse;
import co.com.prueba.api.exception.BadRequestException;
import co.com.prueba.api.exception.NotFoundException;
import co.com.prueba.model.Flights;
import co.com.prueba.usecase.FlightUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("airline/flights")
@Slf4j
public class FlightController {

    private final FlightUseCase flightUseCase;

    public FlightController(FlightUseCase flightUseCase) {
        this.flightUseCase = flightUseCase;
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<Flights>>> buscarFecha(
            @RequestParam("fecha")
            @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
            LocalDateTime fecha) {

        List<Flights> vuelos = flightUseCase.buscarFecha(fecha);

        log.debug("Vuelos encontrados: {} con Fecha: {}", vuelos, fecha);

        return ResponseEntity.ok(new ApiResponse<>(vuelos, 200, "vuelos encontrados"));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Flights>>> listasTodo(){
        return ResponseEntity.ok(
                new ApiResponse<>(flightUseCase.listarTodos(),200,"Listado de Vuelos")
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Flights>> guardar(
            @RequestBody Flights flights){

        Flights result = flightUseCase.guardar(flights);

        log.info("Vuelo creado con Id: {}", result.getFlightId());

        return ResponseEntity.status(201).body(
                new ApiResponse<>(result,201,"Vuelo Creado")
        );
    }

    @PutMapping("/{flightId}")
    public ResponseEntity<ApiResponse<Flights>> actualizarFecha(
            @PathVariable("flightId") Long flightId,
            @RequestParam("fecha")
            @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
            LocalDateTime fecha){

        Flights flights = flightUseCase.buscarPorId(flightId).
                orElseThrow(() -> new NotFoundException("Vuelo no existe"));

        if(fecha.isBefore(LocalDateTime.now())){
            throw new BadRequestException("La fecha no puede ser anterior a la actual");
        }

        flights.setFlightDate(fecha);


        Flights update = flightUseCase.guardar(flights);

        log.info("Fecha de vuelo actualizada: {} con Id: {}", fecha, flightId);

        return ResponseEntity.ok(new ApiResponse<>(update,200,"Fecha actualizada"));

    }

}
