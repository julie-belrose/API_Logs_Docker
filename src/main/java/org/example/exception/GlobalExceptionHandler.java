package org.example.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.example.dto.exception.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * Global exception handler for the application.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ExceptionDto> handleBaseException(BaseException ex, HttpServletRequest request) {
        ExceptionDto dto = ExceptionDto.fromHttpStatus(
                ex.getStatus(),
                ex.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(dto, ex.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDto> handleValidation(MethodArgumentNotValidException ex,
            HttpServletRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return new ResponseEntity<>(
                ExceptionDto.withValidationErrors("Validation failed", request.getRequestURI(), errors),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handleAllUncaughtException(
            Exception ex, 
            HttpServletRequest request) {
        
        ExceptionDto dto = ExceptionDto.fromHttpStatus(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "An unexpected error occurred: " + ex.getMessage(),
                request.getRequestURI()
        );
        
        return new ResponseEntity<>(
                dto, 
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
