package com.tekleo.cryptocompare4j.http_client;

/**
 * Exception that will be used in {@link Client}
 *
 * @author Leo Ertuna
 * @since 19.08.2018 15:00
 */
public class ClientException extends Exception {
    public ClientException() {

    }

    public ClientException(String message) {
        super(message);
    }

    public ClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientException(Throwable cause) {
        super(cause);
    }

    public ClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}