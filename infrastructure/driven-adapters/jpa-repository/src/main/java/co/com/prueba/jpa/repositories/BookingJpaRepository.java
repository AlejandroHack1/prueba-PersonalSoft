package co.com.prueba.jpa.repositories;


import co.com.prueba.model.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingJpaRepository extends JpaRepository<Bookings, Long> {
    List<Bookings> findByUserId(Long userId);
}
