package com.example.GroupProject_4.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionBody> handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        ExceptionBody exceptionBody = ExceptionBody.builder()
                .messages(List.of(ex.getMessage()))
                .timeStamp(LocalDateTime.now())
                .httpStatusCode(notFound.value()+" "+notFound.name())
                .endpoint(request.getRequestURI())
                .build();
        return ResponseEntity.status(notFound).body(exceptionBody);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionBody> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ExceptionBody exceptionBody = ExceptionBody.builder()
                .messages(ex.getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList())
                .timeStamp(LocalDateTime.now())
                .httpStatusCode(badRequest.value()+" "+badRequest.name())
                .endpoint(request.getRequestURI())
                .build();
        return ResponseEntity.status(badRequest)
                .body(exceptionBody);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionBody> handleDataIntegrityViolationException(DataIntegrityViolationException ex, HttpServletRequest request) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ExceptionBody exceptionBody = ExceptionBody.builder()
                .messages(List.of(ex.getMessage()))
                .timeStamp(LocalDateTime.now())
                .httpStatusCode(badRequest.value()+" "+badRequest.name())
                .endpoint(request.getRequestURI())
                .build();
        return ResponseEntity.status(badRequest)
                .body(exceptionBody);
    }

}
