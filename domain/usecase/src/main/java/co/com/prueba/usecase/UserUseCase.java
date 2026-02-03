package co.com.prueba.usecase;

import co.com.prueba.model.Users;
import co.com.prueba.model.gateways.UserRepository;

import java.util.Optional;

public class UserUseCase {

    private final UserRepository userRepository;


    public UserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users guardar(Users users){
        return userRepository.save(users);
    }

    public Optional<Users> buscarPorId(Long userId){
        return userRepository.findById(userId);
    }
}
