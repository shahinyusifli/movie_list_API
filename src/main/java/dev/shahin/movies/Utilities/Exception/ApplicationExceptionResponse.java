package dev.shahin.movies.Utilities.Exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
public class ApplicationExceptionResponse {
    private String message;
    private int status;
    private LocalDateTime time;
}
