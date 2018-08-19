package com.tekleo.cryptocompare4j.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;

/**
 * Model interface
 *
 * @author Leo Ertuna
 * @since 19.08.2018 15:00
 */
public interface Model extends Serializable {
    GsonBuilder GSON_BUILDER = new GsonBuilder();
    Gson GSON = GSON_BUILDER.create();
}