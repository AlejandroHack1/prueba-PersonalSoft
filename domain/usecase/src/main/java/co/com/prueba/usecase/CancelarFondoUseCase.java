package co.com.prueba.usecase;

import co.com.prueba.model.Cliente;
import co.com.prueba.model.Fondo;
import co.com.prueba.model.Transaccion;
import co.com.prueba.model.gateways.ClienteGateway;
import co.com.prueba.model.gateways.FondoGateway;
import co.com.prueba.model.gateways.TransaccionGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CancelarFondoUseCase {

    private final ClienteGateway clienteGateway;
    private final FondoGateway fondoGateway;
    private final TransaccionGateway transaccionGateway;

    public Transaccion cancelar(String clienteId, String fondoId) {

        Cliente cliente = clienteGateway.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Fondo fondo = fondoGateway.findById(fondoId)
                .orElseThrow(() -> new RuntimeException("Fondo no encontrado"));

        Transaccion ultimaApertura = transaccionGateway.findByClienteId(clienteId).stream()
                .filter(tx -> tx.getFondoId().equals(fondoId) && tx.getTipo().equals("APERTURA"))
                .reduce((first, second) -> second)
                .orElseThrow(() -> new RuntimeException("No hay suscripción activa para este fondo"));

        cliente.setSaldo(cliente.getSaldo().add(ultimaApertura.getMonto()));
        clienteGateway.save(cliente);

        Transaccion txCancel = Transaccion.builder()
                .id(UUID.randomUUID().toString())
                .clienteId(clienteId)
                .fondoId(fondoId)
                .monto(ultimaApertura.getMonto())
                .tipo("CANCELACION")
                .fecha(LocalDateTime.now())
                .build();

        transaccionGateway.save(txCancel);

        return txCancel;
    }
}