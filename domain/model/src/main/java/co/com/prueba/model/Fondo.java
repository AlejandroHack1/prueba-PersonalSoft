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
public class Fondo {
    private String id;
    private String nombre;
    private BigDecimal montoMinimo;
    private String categoria;
}
