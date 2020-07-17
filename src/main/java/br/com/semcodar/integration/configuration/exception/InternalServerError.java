package br.com.semcodar.integration.configuration.exception;

public class InternalServerError extends RuntimeException {
    private static final long serialVersionUID = -5365630128856068164L;

    public InternalServerError(String message, Throwable cause) {
        super(message, cause);
    }
}
