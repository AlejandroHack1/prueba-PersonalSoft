package co.com.prueba.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
public class Flights {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightId;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime flightDate;

    @Column(length = 100)
    private String descripcion;

    public Flights() {
    }

    public Flights(Long flightId, String descripcion, LocalDateTime flightDate) {
        this.flightId = flightId;
        this.descripcion = descripcion;
        this.flightDate = flightDate;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public LocalDateTime getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDateTime flightDate) {
        this.flightDate = flightDate;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Flights{" +
                "flightId=" + flightId +
                ", flightDate=" + flightDate +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
