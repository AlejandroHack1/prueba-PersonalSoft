package co.com.prueba.api.controller;

import co.com.prueba.model.Transaccion;
import co.com.prueba.usecase.HistorialTransaccionesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transacciones")
@RequiredArgsConstructor
public class TransaccionController {

    private final HistorialTransaccionesUseCase historialUseCase;

    @GetMapping("/{clienteId}")
    public ResponseEntity<List<Transaccion>> historial(@PathVariable("clienteId") String clienteId) {
        List<Transaccion> historial = historialUseCase.obtenerHistorial(clienteId);
        return ResponseEntity.ok(historial);
    }
}
