package co.com.prueba.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaccion {
    private String id;
    private String clienteId;
    private String fondoId;
    private BigDecimal monto;
    private LocalDateTime fecha;
    private String tipo;
}