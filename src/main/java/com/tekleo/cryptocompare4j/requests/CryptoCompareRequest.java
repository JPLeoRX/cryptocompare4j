package com.tekleo.cryptocompare4j.requests;

import com.tekleo.cryptocompare4j.http_client.Request;

/**
 * Crypto Compare request
 *
 * @author Leo Ertuna
 * @since 19.08.2018 15:00
 */
public interface CryptoCompareRequest extends Request {
    @Override
    default String getBase() {
        return "https://min-api.cryptocompare.com";
    }
}