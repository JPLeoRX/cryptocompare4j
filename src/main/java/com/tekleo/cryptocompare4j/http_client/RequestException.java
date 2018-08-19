package com.tekleo.cryptocompare4j.http_client;

/**
 * Exception that will be used in {@link Request}
 *
 * @author Leo Ertuna
 * @since 19.08.2018 15:00
 */
public class RequestException extends Exception {
    public RequestException() {

    }

    public RequestException(String message) {
        super(message);
    }

    public RequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestException(Throwable cause) {
        super(cause);
    }

    public RequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}