package org.example.dto.log;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.example.enums.LogCategory;
import org.example.enums.LogLevel;

/**
 * Data Transfer Object representing a log entry received or returned by the API.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogDTO {
   private String message;
    private String source;
    private String timestamp;       
    private LogLevel level;         
    private LogCategory category;   
}
