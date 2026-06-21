package br.com.ramon.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ErroResponse {

    private LocalDateTime timestamp;
    private Integer status;
    private String erro;
    private String mensagem;
}