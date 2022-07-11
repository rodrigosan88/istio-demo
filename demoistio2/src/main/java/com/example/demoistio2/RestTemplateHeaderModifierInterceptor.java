package com.example.demoistio2;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class RestTemplateHeaderModifierInterceptor implements ClientHttpRequestInterceptor {

    private final static String X_VERSION = "x-version";
    private final static String X_B3_TRACEID = "x-b3-traceid";
    private final static String X_B3_SPANID = "x-b3-spanid";
    private final static String X_B3_PARENT_SPANID = "x-b3-parentspanid";

    private Logger logger = LoggerFactory.getLogger(RestTemplateHeaderModifierInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        ClientHttpResponse response = execution.execute(request, body);

        response.getHeaders().add(X_VERSION, request.getHeaders().getFirst(X_VERSION));
        response.getHeaders().add(X_B3_TRACEID, request.getHeaders().getFirst(X_B3_TRACEID));
        response.getHeaders().add(X_B3_SPANID, request.getHeaders().getFirst(X_B3_SPANID));
        response.getHeaders().add(X_B3_PARENT_SPANID, request.getHeaders().getFirst(X_B3_PARENT_SPANID));
        
        this.logger.info("Reached headers interceptor.");

        return response;
    }

    
}
