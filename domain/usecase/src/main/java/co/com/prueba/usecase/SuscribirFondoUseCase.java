package co.com.prueba.usecase;

import co.com.prueba.model.Cliente;
import co.com.prueba.model.Fondo;
import co.com.prueba.model.Transaccion;
import co.com.prueba.model.gateways.ClienteGateway;
import co.com.prueba.model.gateways.FondoGateway;
import co.com.prueba.model.gateways.TransaccionGateway;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class SuscribirFondoUseCase {

    private final ClienteGateway clienteGateway;
    private final FondoGateway fondoGateway;
    private final TransaccionGateway transaccionGateway;

    public SuscribirFondoUseCase(ClienteGateway clienteGateway,
                                 FondoGateway fondoGateway,
                                 TransaccionGateway transaccionGateway) {

        this.clienteGateway = clienteGateway;
        this.fondoGateway = fondoGateway;
        this.transaccionGateway = transaccionGateway;
    }

    public Transaccion suscribir(String clienteId, String fondoId, BigDecimal monto) {

        Cliente cliente = clienteGateway.findById(clienteId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado"));

        Fondo fondo = fondoGateway.findById(fondoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fondo no encontrado"));

        if (monto.compareTo(fondo.getMontoMinimo()) < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "El monto es menor al mínimo requerido del fondo " + fondo.getNombre());
        }

        if (cliente.getSaldo().compareTo(monto) < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "No tiene saldo disponible para vincularse al fondo " + fondo.getNombre());
        }

        cliente.setSaldo(cliente.getSaldo().subtract(monto));
        clienteGateway.save(cliente);

        Transaccion tx = Transaccion.builder()
                .id(UUID.randomUUID().toString())
                .clienteId(clienteId)
                .fondoId(fondoId)
                .monto(monto)
                .tipo("APERTURA")
                .fecha(LocalDateTime.now())
                .build();

        transaccionGateway.save(tx);

        return tx;
    }
}