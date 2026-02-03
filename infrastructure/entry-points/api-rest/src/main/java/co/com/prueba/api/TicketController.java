package co.com.prueba.api;

import co.com.prueba.api.controller.ApiResponse;
import co.com.prueba.api.exception.NotFoundException;
import co.com.prueba.model.Tickets;

import co.com.prueba.usecase.TicketUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("airline/tickets")
@Slf4j
public class TicketController {

    private final TicketUseCase ticketUseCase;

    public TicketController(TicketUseCase ticketUseCase) {
        this.ticketUseCase = ticketUseCase;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Tickets>> guardar(
            @RequestBody Tickets tickets){

        Tickets result = ticketUseCase.guardar(tickets);

        log.info("Ticket creado con Id: {}", result.getTicketId());

        return ResponseEntity.status(201).body(
                new ApiResponse<>(result,201,"Ticket Creado")
        );
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<ApiResponse<Tickets>> listarPorId(
            @PathVariable("ticketId") Long ticketId
    ){
        Tickets ticket = ticketUseCase.buscarPorId(ticketId).
                orElseThrow(() -> new NotFoundException("Tiquete no existe"));

        log.debug("Ticket encontrado: {} con Id: {}", ticket, ticketId);

        return ResponseEntity.status(200).body(
                new ApiResponse<>(ticket,200,"Ticket por Id")
        );
    }
}
