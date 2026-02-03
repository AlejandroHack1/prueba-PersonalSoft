package co.com.prueba.jpa.repositories;

import co.com.prueba.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<Users, Long> {
}
