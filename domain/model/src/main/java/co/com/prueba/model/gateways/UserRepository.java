package co.com.prueba.model.gateways;

import co.com.prueba.model.Users;

import java.util.Optional;

public interface UserRepository {

    Optional<Users> findById(Long ticketId);
    Users save(Users users);
}
