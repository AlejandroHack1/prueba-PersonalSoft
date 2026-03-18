package co.com.prueba.mongo.repositories;

import co.com.prueba.mongo.repositories.document.ClienteDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<ClienteDocument, String> { }