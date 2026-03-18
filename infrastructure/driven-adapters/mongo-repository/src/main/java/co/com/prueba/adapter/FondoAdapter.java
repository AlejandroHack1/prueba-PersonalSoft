package co.com.prueba.adapter;

import co.com.prueba.mongo.repositories.FondoRepository;
import co.com.prueba.model.Fondo;
import co.com.prueba.model.gateways.FondoGateway;
import lombok.RequiredArgsConstructor;
import mapper.FondoMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FondoAdapter implements FondoGateway {

    private final FondoRepository repository;

    @Override
    public Optional<Fondo> findById(String id) {
        return repository.findById(id)
                .map(FondoMapper::toDomain);
    }

    @Override
    public Fondo save(Fondo fondo) {
        return FondoMapper.toDomain(
                repository.save(FondoMapper.toDocument(fondo))
        );
    }
}