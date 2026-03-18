package co.com.prueba.mongo.repositories.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clientes")
public class ClienteDocument {
    @Id
    private String id;
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private BigDecimal saldo;
    private String preferenciaNotificacion;
}