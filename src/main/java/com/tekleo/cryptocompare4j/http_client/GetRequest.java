package com.tekleo.cryptocompare4j.http_client;

/**
 * Get Request
 *
 * @author Leo Ertuna
 * @since 19.08.2018 15:00
 */
public interface GetRequest extends Request {
    @Override
    default Type getType() {
        return Type.GET;
    }
}