package co.com.prueba.jpa;

import co.com.prueba.jpa.repositories.UserJpaRepository;
import co.com.prueba.model.Users;
import co.com.prueba.model.gateways.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryAdapter implements UserRepository {

    private final UserJpaRepository userRepository;

    public UserRepositoryAdapter(UserJpaRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Users> findById(Long ticketId) {
        return userRepository.findById(ticketId);
    }

    @Override
    public Users save(Users users) {
        return userRepository.save(users);
    }
}
