package com.tekleo.cryptocompare4j.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Small helper methods to operate on {@link Map}
 *
 * @author Leo Ertuna
 * @since 19.08.2018 15:00
 */
public class MapUtils extends Utils {
    /**
     * Create a map from just one key-value pair
     * @param key key
     * @param value value
     * @param <K> type of the key
     * @param <V> type of the value
     * @return new map
     */
    public static <K, V> Map<K, V> fromOne(K key, V value) {
        // Check for null
        checkForNull(key, value);

        // Create new map
        HashMap<K, V> map = new HashMap<>();
        map.put(key, value);
        return map;
    }

    /**
     * Create a map from only two key-value pairs
     * @param key1 1st key
     * @param value1 1st value
     * @param key2 2nd key
     * @param value2 2nd value
     * @param <K> type of the key
     * @param <V> type of the value
     * @return new map
     */
    public static <K, V> Map<K, V> fromTwo(K key1, V value1, K key2, V value2) {
        // Check for null
        checkForNull(key1, value1, key2, value2);

        // Create new map
        HashMap<K, V> map = new HashMap<>();
        map.put(key1, value1);
        map.put(key2, value2);
        return map;
    }

    /**
     * Convert both key and value objects to strings
     * @param map existing map
     * @param <K> type of the key
     * @param <V> type of the value
     * @return map of strings
     */
    public static <K, V> Map<String, String> toString(Map<K, V> map) {
        // Check for null
        checkForNull(map);

        // Convert each key=value pair from objects to strings
        return map.entrySet().stream().collect(Collectors.toMap(String::valueOf, String::valueOf));
    }
}