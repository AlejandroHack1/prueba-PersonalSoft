package co.com.prueba.jpa.repositories;

import co.com.prueba.model.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketJpaRepository extends JpaRepository<Tickets, Long> {
}
