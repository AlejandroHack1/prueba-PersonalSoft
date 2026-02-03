package co.com.prueba.jpa;

import co.com.prueba.jpa.repositories.TicketJpaRepository;
import co.com.prueba.model.Tickets;
import co.com.prueba.model.gateways.TicketRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TicketRepositoryAdapter implements TicketRepository {

    private final TicketJpaRepository ticketRepository;

    public TicketRepositoryAdapter(TicketJpaRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Optional<Tickets> findById(Long ticketId) {
        return ticketRepository.findById(ticketId);
    }

    @Override
    public Tickets save(Tickets tickets) {
        return ticketRepository.save(tickets);
    }
}
