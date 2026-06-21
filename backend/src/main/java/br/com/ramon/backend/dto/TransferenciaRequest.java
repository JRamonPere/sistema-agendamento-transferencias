package br.com.ramon.backend.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class TransferenciaRequest {

    @NotBlank(message = "A conta de origem é obrigatória")
    @Pattern(regexp = "\\d{10}", message = "A conta de origem deve conter exatamente 10 dígitos")
    private String contaOrigem;

    @NotBlank(message = "A conta de destino é obrigatória")
    @Pattern(regexp = "\\d{10}", message = "A conta de destino deve conter exatamente 10 dígitos")
    private String contaDestino;

    @NotNull(message = "O valor da transferência é obrigatório")
    @DecimalMin(value = "0.01", message = "O valor da transferência deve ser maior que zero")
    private BigDecimal valorTransferencia;

    @NotNull(message = "A data da transferência é obrigatória")
    private LocalDate dataTransferencia;
}