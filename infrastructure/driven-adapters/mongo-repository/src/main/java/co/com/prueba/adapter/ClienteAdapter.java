package co.com.prueba.adapter;

import co.com.prueba.model.Cliente;
import co.com.prueba.model.gateways.ClienteGateway;
import co.com.prueba.mongo.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;
import mapper.ClienteMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ClienteAdapter implements ClienteGateway {

    private final ClienteRepository repository;

    @Override
    public Optional<Cliente> findById(String id) {
        return repository.findById(id)
                .map(ClienteMapper::toDomain);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return ClienteMapper.toDomain(
                repository.save(ClienteMapper.toDocument(cliente))
        );
    }
}