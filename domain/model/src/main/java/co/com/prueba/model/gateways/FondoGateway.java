package co.com.prueba.model.gateways;

import co.com.prueba.model.Fondo;

import java.util.Optional;

public interface FondoGateway {
    Optional<Fondo> findById(String id);
    Fondo save(Fondo fondo);
}
