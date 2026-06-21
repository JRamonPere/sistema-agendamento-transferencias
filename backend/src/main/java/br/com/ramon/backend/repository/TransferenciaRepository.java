package br.com.ramon.backend.repository;

import br.com.ramon.backend.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
}