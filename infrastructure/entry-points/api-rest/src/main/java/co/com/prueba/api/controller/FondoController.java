package co.com.prueba.api.controller;

import co.com.prueba.model.Transaccion;
import co.com.prueba.usecase.CancelarFondoUseCase;
import co.com.prueba.usecase.SuscribirFondoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@RestController
@RequestMapping("/fondos")
@RequiredArgsConstructor
public class FondoController {

    private final SuscribirFondoUseCase suscribirFondoUseCase;
    private final CancelarFondoUseCase cancelarFondoUseCase;

    public static class SuscribirRequest {
        public String clienteId;
        public String fondoId;
        public BigDecimal monto;
    }

    @PostMapping("/suscribir")
    public ResponseEntity<?> suscribir(@RequestBody SuscribirRequest request) {
        try {
            Transaccion tx = suscribirFondoUseCase.suscribir(
                    request.clienteId,
                    request.fondoId,
                    request.monto
            );
            return ResponseEntity.ok(tx);
        } catch (ResponseStatusException e) {
            return ResponseEntity
                    .status(e.getStatusCode())
                    .body(new ErrorResponse(e.getReason()));
        }
    }

    public static class CancelarRequest {
        public String clienteId;
        public String fondoId;
    }

    @PostMapping("/cancelar")
    public ResponseEntity<Transaccion> cancelar(@RequestBody CancelarRequest request) {
        try {
            Transaccion tx = cancelarFondoUseCase.cancelar(
                    request.clienteId,
                    request.fondoId
            );
            return ResponseEntity.ok(tx);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    public static class ErrorResponse {
        public String mensaje;
        public ErrorResponse(String mensaje) {
            this.mensaje = mensaje;
        }
    }
}
