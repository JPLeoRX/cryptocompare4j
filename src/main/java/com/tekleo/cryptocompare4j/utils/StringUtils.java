package com.tekleo.cryptocompare4j.utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Small helper methods to operate on {@link String}
 *
 * @author Leo Ertuna
 * @since 19.08.2018 15:00
 */
public class StringUtils extends Utils {
    /**
     * Join several strings in one
     * @param words strings to be joined
     * @param deliminator deliminator is put after each next word
     * @return joined string
     */
    public static String join(List<String> words, String deliminator) {
        // Check for null
        checkForNull(words, deliminator);

        // Create new string builder
        StringBuilder joinedWordsBuilder = new StringBuilder();

        // For each word - add deliminator to it and append to the string builder
        IntStream.range(0, words.size()).forEach(index -> {
            // If this is the last word - don't add deliminator
            if (index == words.size() - 1)
                joinedWordsBuilder.append(words.get(index));

            // If this is just a regular word - add deliminator
            else
                joinedWordsBuilder.append(words.get(index)).append(deliminator);
        });

        // Extract resulting string
        return joinedWordsBuilder.toString();
    }

    /**
     * Join map entries with key + delim + value approach and put them in a list
     * @param map map to be converted
     * @param keyValueDeliminator deliminator between key and value
     * @return list
     */
    public static List<String> toList(Map<String, String> map, String keyValueDeliminator) {
        // Check for null
        checkForNull(map, keyValueDeliminator);

        // Convert each entry to a joined word
        return map.entrySet().stream().map(entry -> entry.getKey() + keyValueDeliminator + entry.getValue()).collect(Collectors.toList());
    }

    /**
     * Join map entries into one string. key1 + kvDelim + value1 + pDelim + key2 + ... + valueN
     * @param map map to be joined
     * @param keyValueDeliminator deliminator between key and value
     * @param pairsDeliminator deliminator between each key-value pair
     * @return joined string
     */
    public static String join(Map<String, String> map, String keyValueDeliminator, String pairsDeliminator) {
        return join(toList(map, keyValueDeliminator), pairsDeliminator);
    }
}