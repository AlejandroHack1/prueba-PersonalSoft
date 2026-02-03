package co.com.prueba.config;

import co.com.prueba.model.gateways.BookingRepository;
import co.com.prueba.model.gateways.FlightRepository;
import co.com.prueba.model.gateways.TicketRepository;
import co.com.prueba.model.gateways.UserRepository;
import co.com.prueba.usecase.BookingUseCase;
import co.com.prueba.usecase.FlightUseCase;
import co.com.prueba.usecase.TicketUseCase;
import co.com.prueba.usecase.UserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public BookingUseCase bookingUseCase(
            BookingRepository bookingRepository,
            FlightRepository flightRepository,
            TicketRepository ticketRepository
    ){
        return new BookingUseCase(bookingRepository,flightRepository,ticketRepository);
    }

    @Bean
    public FlightUseCase flightUseCase(
            FlightRepository flightRepository
    ){
        return new FlightUseCase(flightRepository);
    }

    @Bean
    public TicketUseCase ticketUseCase(
            TicketRepository ticketRepository
    ){
        return new TicketUseCase(ticketRepository);
    }

    @Bean
    public UserUseCase userUseCase(
            UserRepository userRepository
    ){
        return new UserUseCase(userRepository);
    }

}
