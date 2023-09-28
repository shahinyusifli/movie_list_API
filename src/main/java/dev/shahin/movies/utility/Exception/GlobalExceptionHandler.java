package dev.shahin.movies.utility.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        ApplicationExceptionResponse exceptionResponse = new ApplicationExceptionResponse(ex.getMessage(), ex.getStatusCode().toString(), LocalDateTime.now());
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NO_CONTENT);
    };
}
