package co.com.prueba.usecase;

import co.com.prueba.model.Transaccion;
import co.com.prueba.model.gateways.TransaccionGateway;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialTransaccionesUseCase {

    private final TransaccionGateway transaccionGateway;

    public HistorialTransaccionesUseCase(TransaccionGateway transaccionGateway) {
        this.transaccionGateway = transaccionGateway;
    }

    public List<Transaccion> obtenerHistorial(String clienteId) {
        return transaccionGateway.findByClienteId(clienteId);
    }
}