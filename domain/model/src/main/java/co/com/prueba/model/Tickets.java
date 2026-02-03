package co.com.prueba.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tickets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    public Tickets() {
    }

    public Tickets(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "ticketId=" + ticketId +
                '}';
    }
}
