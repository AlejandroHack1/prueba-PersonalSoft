package mapper;

import co.com.prueba.model.Cliente;
import co.com.prueba.mongo.repositories.document.ClienteDocument;

public class ClienteMapper {

    public static Cliente toDomain(ClienteDocument doc) {
        return Cliente.builder()
                .id(doc.getId())
                .nombre(doc.getNombre())
                .apellidos(doc.getApellidos())
                .email(doc.getEmail())
                .telefono(doc.getTelefono())
                .saldo(doc.getSaldo())
                .preferenciaNotificacion(doc.getPreferenciaNotificacion())
                .build();
    }

    public static ClienteDocument toDocument(Cliente cliente) {
        return ClienteDocument.builder()
                .id(cliente.getId())
                .nombre(cliente.getNombre())
                .apellidos(cliente.getApellidos())
                .email(cliente.getEmail())
                .telefono(cliente.getTelefono())
                .saldo(cliente.getSaldo())
                .preferenciaNotificacion(cliente.getPreferenciaNotificacion())
                .build();
    }
}
