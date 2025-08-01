package org.example.exception;

import org.springframework.http.HttpStatus;

/**
 * Base exception class for all custom exceptions in the application.
 */
public abstract class BaseException extends RuntimeException {
    
    private final HttpStatus status;
    
    protected BaseException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
    
    public HttpStatus getStatus() {
        return status;
    }
}
