package co.com.prueba.config;

import co.com.prueba.model.gateways.ClienteGateway;
import co.com.prueba.model.gateways.FondoGateway;
import co.com.prueba.model.gateways.TransaccionGateway;
import co.com.prueba.usecase.CancelarFondoUseCase;
import co.com.prueba.usecase.HistorialTransaccionesUseCase;
import co.com.prueba.usecase.SuscribirFondoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {


    @Bean
    public SuscribirFondoUseCase suscribirFondoUseCase(
            ClienteGateway clienteGateway,
            FondoGateway fondoGateway,
            TransaccionGateway transaccionGateway
    ) {
        return new SuscribirFondoUseCase(clienteGateway, fondoGateway, transaccionGateway);
    }

    @Bean
    public CancelarFondoUseCase cancelarFondoUseCase(
            ClienteGateway clienteGateway,
            FondoGateway fondoGateway,
            TransaccionGateway transaccionGateway
    ) {
        return new CancelarFondoUseCase(clienteGateway, fondoGateway, transaccionGateway);
    }

    @Bean
    public HistorialTransaccionesUseCase historialTransaccionesUseCase(
            TransaccionGateway transaccionGateway
    ) {
        return new HistorialTransaccionesUseCase(transaccionGateway);
    }
}
