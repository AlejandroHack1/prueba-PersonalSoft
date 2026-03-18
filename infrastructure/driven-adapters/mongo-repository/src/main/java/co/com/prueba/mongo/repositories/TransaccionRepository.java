package co.com.prueba.mongo.repositories;

import co.com.prueba.model.Transaccion;
import co.com.prueba.mongo.repositories.document.TransaccionDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransaccionRepository extends MongoRepository<TransaccionDocument, String> {
    List<TransaccionDocument> findByClienteId(String clienteId);
}