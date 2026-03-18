package co.com.prueba.adapter;

import co.com.prueba.model.Transaccion;
import co.com.prueba.model.gateways.TransaccionGateway;
import co.com.prueba.mongo.repositories.TransaccionRepository;
import lombok.RequiredArgsConstructor;
import mapper.TransaccionMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class TransaccionAdapter implements TransaccionGateway {

    private final TransaccionRepository repository;

    @Override
    public Transaccion save(Transaccion tx) {
        return TransaccionMapper.toDomain(
                repository.save(TransaccionMapper.toDocument(tx))
        );
    }

    @Override
    public List<Transaccion> findByClienteId(String clienteId) {
        return repository.findByClienteId(clienteId)
                .stream()
                .map(TransaccionMapper::toDomain)
                .collect(Collectors.toList());
    }
}
