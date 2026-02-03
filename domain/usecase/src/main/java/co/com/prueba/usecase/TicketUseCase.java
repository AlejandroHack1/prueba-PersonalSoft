package co.com.prueba.usecase;

import co.com.prueba.model.Tickets;
import co.com.prueba.model.gateways.TicketRepository;
import java.util.Optional;

public class TicketUseCase {

    private final TicketRepository ticketRepository;

    public TicketUseCase(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Tickets guardar(Tickets tickets){
        return ticketRepository.save(tickets);
    }

    public Optional<Tickets> buscarPorId(Long ticketId){
        return ticketRepository.findById(ticketId);
    }
}
