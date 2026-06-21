package br.com.ramon.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transferencias")
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String contaOrigem;

    @Column(nullable = false, length = 10)
    private String contaDestino;

    @Column(nullable = false)
    private BigDecimal valorTransferencia;

    @Column(nullable = false)
    private BigDecimal taxa;

    @Column(nullable = false)
    private LocalDate dataTransferencia;

    @Column(nullable = false)
    private LocalDate dataAgendamento;
}