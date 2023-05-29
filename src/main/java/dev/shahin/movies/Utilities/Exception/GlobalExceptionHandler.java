/*
package dev.shahin.movies.Utilities.Exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import jakarta.validation.ValidationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    protected ResponseEntity<ApplicationExceptionResponse> handleMethodArgumentNotValid(Exception ex) {
        ApplicationExceptionResponse response=
                ApplicationExceptionResponse.builder().message(ex.getMessage())
                        .status(HttpStatus.BAD_REQUEST.value()).time(LocalDateTime.now()).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(response);
    }





}*/
