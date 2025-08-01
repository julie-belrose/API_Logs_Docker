package org.example.dto.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * DTO for exception responses.
 */

public record ExceptionDto(
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    LocalDateTime timestamp,
    int status,
    String error,
    String message,
    String path,
    Map<String, String> errors
) {
    public static ExceptionDto fromHttpStatus(HttpStatus status, String message, String path) {
        return new ExceptionDto(
            LocalDateTime.now(),
            status.value(),
            status.getReasonPhrase(),
            message,
            path,
            null
        );
    }

    public static ExceptionDto withValidationErrors(String message, String path, Map<String, String> errors) {
        return new ExceptionDto(
            LocalDateTime.now(),
            HttpStatus.BAD_REQUEST.value(),
            HttpStatus.BAD_REQUEST.getReasonPhrase(),
            message,
            path,
            errors
        );
    }
}