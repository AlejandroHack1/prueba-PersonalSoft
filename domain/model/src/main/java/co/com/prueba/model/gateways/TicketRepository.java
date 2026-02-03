package co.com.prueba.model.gateways;

import co.com.prueba.model.Tickets;

import java.util.Optional;

public interface TicketRepository {

    Optional<Tickets> findById(Long ticketId);
    Tickets save(Tickets tickets);
}
