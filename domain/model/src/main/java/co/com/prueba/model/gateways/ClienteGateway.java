package co.com.prueba.model.gateways;

import co.com.prueba.model.Cliente;

import java.util.Optional;

public interface ClienteGateway {
    Optional<Cliente> findById(String id);
    Cliente save(Cliente cliente);
}