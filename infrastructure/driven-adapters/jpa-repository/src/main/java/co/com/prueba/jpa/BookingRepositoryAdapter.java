package co.com.prueba.jpa;

import co.com.prueba.jpa.repositories.BookingJpaRepository;
import co.com.prueba.model.Bookings;
import co.com.prueba.model.gateways.BookingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookingRepositoryAdapter implements BookingRepository {

    private final BookingJpaRepository bookingRepository;

    public BookingRepositoryAdapter(BookingJpaRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }


    @Override
    public Bookings save(Bookings bookings) {
        return bookingRepository.save(bookings);
    }

    @Override
    public Optional<Bookings> findById(Long bookingId) {
        return bookingRepository.findById(bookingId);
    }

    @Override
    public boolean existById(Long bookingId) {
        return bookingRepository.existsById(bookingId);
    }

    @Override
    public List<Bookings> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Bookings> findByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    @Override
    public void deleteById(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
