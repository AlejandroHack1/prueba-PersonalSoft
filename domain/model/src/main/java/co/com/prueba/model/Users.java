package co.com.prueba.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Pattern(regexp = "^[A-Za-z ]{1,30}$")
    @Column(length = 30, nullable = false)
    private String nombre;

    public Users() {
    }

    public Users(Long userId, String nombre) {
        this.userId = userId;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
