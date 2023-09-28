package dev.shahin.movies.utility.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationExceptionResponse {
    private String message;
    private String status;
    private LocalDateTime time;
}
