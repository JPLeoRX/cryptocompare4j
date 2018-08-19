package com.tekleo.cryptocompare4j.http_client;

import com.tekleo.cryptocompare4j.utils.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * This interface identifies that an object acts as a Request in this REST client
 *
 * @author Leo Ertuna
 * @since 19.08.2018 15:00
 */
public interface Request {
    String ARGUMENTS_DELIMINATOR = "|";
    String PARAMETERS_DELIMINATOR = "&";

    /**
     * @return type of this request
     */
    Type getType();

    /**
     * @return base of this request like "www.example.com/api" in REST request to "www.example.com/api/list_users"
     */
    String getBase();

    /**
     * @return method of this request like "/list_users" in REST request to "www.example.com/api/list_users"
     */
    String getMethod();

    /**
     * @return method of this request like "female" in REST request to "www.example.com/api/list_users/female"
     */
    List<String> getArguments();

    /**
     * @return parameters of this request like "a=1" in REST request to "www.example.com/api/ask?a=1"
     */
    Map<String, String> getParameters();

    /**
     * Form the url from all the arguments and parameters
     * @return url
     */
    default String getUrl() {
        // Get base url
        String url = getBase() + getMethod();

        // If there are any arguments
        if (getArguments() != null && !getArguments().isEmpty())
            url += "/" + StringUtils.join(getArguments(), ARGUMENTS_DELIMINATOR);

        // If there are any parameters and it's a get request
        if (getParameters() != null && !getParameters().isEmpty() && getType() == Type.GET)
            url += "?" + StringUtils.join(getParameters(), "=", PARAMETERS_DELIMINATOR);

        // Return resulting url
        return url;
    }

    /**
     * Send the request via the {@link Client} and return the JSON response
     * @return json response
     */
    default String send() throws RequestException {
        try {
            return new Client(getType(), getUrl()).send();
        } catch (ClientException e) {
            throw new RequestException("Failed to send request", e);
        }
    }

    /**
     * Request Type Enum
     */
    public static enum Type {
        GET, POST, PUT, DELETE;
    }
}