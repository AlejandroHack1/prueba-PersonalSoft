package co.com.prueba.api.exception;

import co.com.prueba.api.controller.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleNotFound(NotFoundException e){
        log.warn("Recurso no encontrado: {}", e.getMessage());
        return ResponseEntity.status(404)
                .body(new ApiResponse<>(null,404,e.getMessage()));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse<Object>> handleNotFound(BadRequestException e){
        return ResponseEntity.status(400)
                .body(new ApiResponse<>(null,400,e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleNotFound(Exception e){
        log.error("Error Servidor: {}", e.getMessage());
        return ResponseEntity.status(500)
                .body(new ApiResponse<>(null,500,e.getMessage()));
    }

}
