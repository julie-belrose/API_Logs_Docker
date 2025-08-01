package org.example.domain;

import org.example.dto.log.LogDTO;

public class LogSanitizer {

    public static LogDTO sanitize(LogDTO input) {
        String sanitizedMessage = input.getMessage()
                .replaceAll("\\b\\d{1,3}(\\.\\d{1,3}){3}\\b", "[IP]")      // IP
                .replaceAll("\\b\\w+@\\w+\\.\\w+\\b", "[EMAIL]");         // email

        input.setMessage(sanitizedMessage);
        return input;
    }
}
