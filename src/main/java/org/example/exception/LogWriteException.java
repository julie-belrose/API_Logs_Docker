package org.example.exception;

import org.springframework.http.HttpStatus;

/**
 * Custom exception thrown when writing a log fails.
 */
public class LogWriteException extends BaseException {
    
    public LogWriteException(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

    public LogWriteException(String message, Throwable cause) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
        initCause(cause);
    }
}
