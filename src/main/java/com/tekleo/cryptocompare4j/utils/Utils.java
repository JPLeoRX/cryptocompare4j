package com.tekleo.cryptocompare4j.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/**
 * Common utils parent
 *
 * @author Leo Ertuna
 * @since 19.08.2018 15:00
 */
public abstract class Utils {
    /**
     * Null check
     * @param objects objects
     */
    protected static void checkForNull(Object ... objects) {
        // For each object
        Arrays.asList(objects).stream().forEach(object -> {
            // If the object is null
            if (object == null)
                throw new IllegalArgumentException("The argument is null");

            // If this is a collection
            else if (object instanceof Collection) {
                // Convert to collection
                Collection collection = (Collection) object;

                // If collection is empty
                if (collection.isEmpty())
                    throw new IllegalArgumentException("The collection is empty");
            }

            // If this object is a map
            else if (object instanceof Map) {
                // Convert to a map
                Map map = (Map) object;

                // If map is empty
                if (map.isEmpty())
                    throw new IllegalArgumentException("The collection is empty");
            }

            // If this is a string
            else if (object instanceof String) {
                // Convert to string
                String str = (String) object;

                // If string is empty
                if (str.isEmpty())
                    throw new IllegalArgumentException("The string is empty");
            }
        });
    }
}