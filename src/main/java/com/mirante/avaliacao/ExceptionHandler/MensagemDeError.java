package com.mirante.avaliacao.ExceptionHandler;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record MensagemDeError(
        LocalDateTime timestamp,
        int status,
        String titulo,
        String mensagem
) {
}
