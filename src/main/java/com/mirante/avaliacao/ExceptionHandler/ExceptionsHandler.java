package com.mirante.avaliacao.ExceptionHandler;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<MensagemDeError> handleEntityNotFoundException(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(criaMensagemDeError(ex, HttpStatus.NOT_FOUND, "Not Found"));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<MensagemDeError> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(criaMensagemDeError(ex, HttpStatus.BAD_REQUEST, "Bad Request"));
    }

    private MensagemDeError criaMensagemDeError(Exception ex, HttpStatus status, String titulo) {
        return MensagemDeError.builder()
                .titulo(titulo)
                .mensagem(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .status(status.value())
                .build();
    }
}
