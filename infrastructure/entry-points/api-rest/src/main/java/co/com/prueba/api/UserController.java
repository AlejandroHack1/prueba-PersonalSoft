package co.com.prueba.api;

import co.com.prueba.api.controller.ApiResponse;
import co.com.prueba.api.exception.NotFoundException;
import co.com.prueba.model.Users;
import co.com.prueba.usecase.UserUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("airline/users")
@Slf4j
public class UserController {

    private final UserUseCase userUseCase;

    public UserController(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Users>> guardar(
            @RequestBody Users users){

        Users result = userUseCase.guardar(users);

        log.info("Usuario creado con Id: {}", result.getUserId());

        return ResponseEntity.status(201).body(
                new ApiResponse<>(result,201,"User Creado")
        );
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<Users>> listarPorId(
            @PathVariable("userId") Long userId
            ){

        Users usuario = userUseCase.buscarPorId(userId).
                orElseThrow(() -> new NotFoundException("Usuario no existe"));

        log.debug("Usuario encontrado: {} con Id: {}", usuario, userId);

        return ResponseEntity.status(200).body(
                new ApiResponse<>(usuario,200,"Usuario por Id")
        );
    }
}
