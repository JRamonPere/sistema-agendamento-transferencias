package br.com.ramon.backend.controller;

import br.com.ramon.backend.dto.TransferenciaRequest;
import br.com.ramon.backend.model.Transferencia;
import br.com.ramon.backend.service.TransferenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

    private final TransferenciaService transferenciaService;

    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @PostMapping
    public ResponseEntity<Transferencia> agendar(@Valid @RequestBody TransferenciaRequest request) {
        Transferencia transferencia = transferenciaService.agendar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(transferencia);
    }

    @GetMapping
    public ResponseEntity<List<Transferencia>> listar() {
        List<Transferencia> transferencias = transferenciaService.listar();
        return ResponseEntity.ok(transferencias);
    }
}