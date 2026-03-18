package co.com.prueba.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private String id;
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private BigDecimal saldo;
    private String preferenciaNotificacion;
}