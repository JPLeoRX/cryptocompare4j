package com.tekleo.cryptocompare4j.http_client;

/**
 * Put Request
 *
 * @author Leo Ertuna
 * @since 19.08.2018 15:00
 */
public interface PutRequest extends Request {
    @Override
    default Type getType() {
        return Type.PUT;
    }
}