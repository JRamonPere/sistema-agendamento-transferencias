package br.com.ramon.backend.exception;

public class TaxaNaoAplicavelException extends RuntimeException {

    public TaxaNaoAplicavelException(String message) {
        super(message);
    }
}