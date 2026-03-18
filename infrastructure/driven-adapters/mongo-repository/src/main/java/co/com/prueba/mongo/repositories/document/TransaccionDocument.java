package co.com.prueba.mongo.repositories.document;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "transacciones")
public class TransaccionDocument {
    @Id
    private String id;
    private String clienteId;
    private String fondoId;
    private BigDecimal monto;
    private LocalDateTime fecha;
    private String tipo;
}