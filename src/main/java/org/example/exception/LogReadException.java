package org.example.exception;

import org.springframework.http.HttpStatus;

/**
 * Custom exception thrown when reading a log fails.
 */
public class LogReadException extends BaseException {

    public LogReadException(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

    public LogReadException(String message, Throwable cause) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
        initCause(cause);
    }
}
