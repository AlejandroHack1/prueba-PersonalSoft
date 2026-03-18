package mapper;

import co.com.prueba.model.Transaccion;
import co.com.prueba.mongo.repositories.document.TransaccionDocument;

public class TransaccionMapper {

    public static Transaccion toDomain(TransaccionDocument doc) {
        return Transaccion.builder()
                .id(doc.getId())
                .clienteId(doc.getClienteId())
                .fondoId(doc.getFondoId())
                .monto(doc.getMonto())
                .fecha(doc.getFecha())
                .tipo(doc.getTipo())
                .build();
    }

    public static TransaccionDocument toDocument(Transaccion tx) {
        return TransaccionDocument.builder()
                .id(tx.getId())
                .clienteId(tx.getClienteId())
                .fondoId(tx.getFondoId())
                .monto(tx.getMonto())
                .fecha(tx.getFecha())
                .tipo(tx.getTipo())
                .build();
    }

}