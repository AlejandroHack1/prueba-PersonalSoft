package co.com.prueba.model.gateways;

import co.com.prueba.model.Transaccion;

import java.util.List;

public interface TransaccionGateway {
    Transaccion save(Transaccion tx);
    List<Transaccion> findByClienteId(String clienteId);
}
