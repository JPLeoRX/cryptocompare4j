package com.tekleo.cryptocompare4j.http_client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Client
 *
 * This class will execute http requests
 *
 * @author Leo Ertuna
 * @since 19.08.2018 15:00
 */
public class Client {
    private Request.Type type;
    private String url;

    private BasicHeader jsonHeader;
    private HttpClient client;
    private HttpUriRequest request;
    private HttpResponse response;
    private HttpEntity entity;
    private String jsonResponse;

    // Constructors
    //------------------------------------------------------------------------------------------------------------------
    public Client(Request.Type type, String url) {
        this.type = type;
        this.url = url;
    }
    //------------------------------------------------------------------------------------------------------------------



    // Build the request
    //------------------------------------------------------------------------------------------------------------------
    private void createHeaders() {
        jsonHeader = new BasicHeader(HttpHeaders.ACCEPT, "application/json");
    }

    private void createClient() {
        client = HttpClients.custom().build();
    }

    private void createDeleteRequest() {
        request = RequestBuilder.delete().setUri(url).setHeader(jsonHeader).build();
    }

    private void createGetRequest() {
        request = RequestBuilder.get().setUri(url).setHeader(jsonHeader).build();
    }

    private void createPostRequest() {
        request = RequestBuilder.post().setUri(url).setHeader(jsonHeader).build();
    }

    private void createPutRequest() {
        request = RequestBuilder.put().setUri(url).setHeader(jsonHeader).build();
    }

    private void createRequest() throws ClientException {
        if (type == Request.Type.DELETE)
            createDeleteRequest();
        else if (type == Request.Type.GET)
            createGetRequest();
        else if (type == Request.Type.POST)
            createPostRequest();
        else if (type == Request.Type.PUT)
            createPutRequest();
        else
            throw new ClientException("Other types are not supported in this client. type=" + type);
    }
    //------------------------------------------------------------------------------------------------------------------



    // Execute the request
    //------------------------------------------------------------------------------------------------------------------
    private void executeRequest() throws ClientException {
        try {
            response = client.execute(request);
        }

        catch (IOException e) {
            throw new ClientException("Failed to execute request", e);
        }
    }

    private void extractEntity() {
        entity = response.getEntity();
    }

    private void extractJson() throws ClientException {
        try {
            jsonResponse = EntityUtils.toString(entity);
        }

        catch (IOException e) {
            throw new ClientException("Failed to extract json", e);
        }
    }
    //------------------------------------------------------------------------------------------------------------------



    // Public methods
    //------------------------------------------------------------------------------------------------------------------
    /**
     * Build and execute the request, returning JSON response
     * @return json response
     */
    public String send() throws ClientException {
        createHeaders();
        createClient();
        createRequest();
        executeRequest();
        extractEntity();
        extractJson();
        return jsonResponse;
    }
    //------------------------------------------------------------------------------------------------------------------
}