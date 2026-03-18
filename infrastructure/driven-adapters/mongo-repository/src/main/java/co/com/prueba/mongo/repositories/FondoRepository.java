package co.com.prueba.mongo.repositories;

import co.com.prueba.mongo.repositories.document.FondoDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FondoRepository extends MongoRepository<FondoDocument, String> { }
