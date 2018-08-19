package com.tekleo.cryptocompare4j.http_client;

/**
 * Delete Request
 *
 * @author Leo Ertuna
 * @since 19.08.2018 15:00
 */
public interface DeleteRequest extends Request {
    @Override
    default Type getType() {
        return Type.DELETE;
    }
}