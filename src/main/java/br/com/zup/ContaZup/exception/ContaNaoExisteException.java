package br.com.zup.ContaZup.exception;

public class ContaNaoExisteException extends RuntimeException {
    public ContaNaoExisteException(String message) {
        super(message);
    }
}
