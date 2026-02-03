package co.com.prueba.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @NotNull
    private Long userId;

    @NotNull
    private Long flightId;

    @NotNull
    private Long ticketId;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime bookingDate;

    @Pattern(regexp = "^[A-Za-z ]{1,30}$")
    @Column(length = 30)
    private String nombre;

    @Pattern(regexp = "^[A-Za-z0-9 ]{0,100}$")
    @Column(length = 100)
    private String observaciones;

    public Bookings() {
    }

    public Bookings(Long id, Long userId, Long flightId, Long ticketId, LocalDateTime bookingDate, String nombre, String observaciones) {
        this.bookingId = id;
        this.userId = userId;
        this.flightId = flightId;
        this.ticketId = ticketId;
        this.bookingDate = bookingDate;
        this.nombre = nombre;
        this.observaciones = observaciones;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long id) {
        this.bookingId = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Bookings{" +
                "bookingId=" + bookingId +
                ", userId=" + userId +
                ", flightId=" + flightId +
                ", ticketId=" + ticketId +
                ", bookingDate=" + bookingDate +
                ", nombre='" + nombre + '\'' +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }
}