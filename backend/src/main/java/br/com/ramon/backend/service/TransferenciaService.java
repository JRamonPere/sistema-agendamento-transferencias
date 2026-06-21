package br.com.ramon.backend.service;

import br.com.ramon.backend.dto.TransferenciaRequest;
import br.com.ramon.backend.exception.TaxaNaoAplicavelException;
import br.com.ramon.backend.model.Transferencia;
import br.com.ramon.backend.repository.TransferenciaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class TransferenciaService {

    private final TransferenciaRepository transferenciaRepository;

    public TransferenciaService(TransferenciaRepository transferenciaRepository) {
        this.transferenciaRepository = transferenciaRepository;
    }

    public Transferencia agendar(TransferenciaRequest request) {
        LocalDate dataAgendamento = LocalDate.now();

        long dias = ChronoUnit.DAYS.between(
                dataAgendamento,
                request.getDataTransferencia()
        );

        if (dias < 0) {
            throw new TaxaNaoAplicavelException(
                    "A data da transferência não pode ser anterior à data de agendamento."
            );
        }

        BigDecimal taxa = calcularTaxa(request.getValorTransferencia(), dias);

        Transferencia transferencia = new Transferencia();
        transferencia.setContaOrigem(request.getContaOrigem());
        transferencia.setContaDestino(request.getContaDestino());
        transferencia.setValorTransferencia(request.getValorTransferencia());
        transferencia.setTaxa(taxa);
        transferencia.setDataTransferencia(request.getDataTransferencia());
        transferencia.setDataAgendamento(dataAgendamento);

        return transferenciaRepository.save(transferencia);
    }

    public List<Transferencia> listar() {
        return transferenciaRepository.findAll();
    }

    private BigDecimal calcularTaxa(BigDecimal valorTransferencia, long dias) {
        BigDecimal taxaFixa;
        BigDecimal percentual;

        if (dias == 0) {
            taxaFixa = new BigDecimal("3.00");
            percentual = new BigDecimal("0.025");
        } else if (dias >= 1 && dias <= 10) {
            taxaFixa = new BigDecimal("12.00");
            percentual = BigDecimal.ZERO;
        } else if (dias >= 11 && dias <= 20) {
            taxaFixa = BigDecimal.ZERO;
            percentual = new BigDecimal("0.082");
        } else if (dias >= 21 && dias <= 30) {
            taxaFixa = BigDecimal.ZERO;
            percentual = new BigDecimal("0.069");
        } else if (dias >= 31 && dias <= 40) {
            taxaFixa = BigDecimal.ZERO;
            percentual = new BigDecimal("0.047");
        } else if (dias >= 41 && dias <= 50) {
            taxaFixa = BigDecimal.ZERO;
            percentual = new BigDecimal("0.017");
        } else {
            throw new TaxaNaoAplicavelException(
                    "Não existe taxa aplicável para a data de transferência informada."
            );
        }

        BigDecimal taxaPercentual = valorTransferencia.multiply(percentual);

        return taxaFixa
                .add(taxaPercentual)
                .setScale(2, RoundingMode.HALF_UP);
    }
}