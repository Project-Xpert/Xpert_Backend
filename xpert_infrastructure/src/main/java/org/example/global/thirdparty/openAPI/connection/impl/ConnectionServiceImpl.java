package org.example.global.thirdparty.openAPI.connection.impl;

import lombok.RequiredArgsConstructor;
import org.example.global.thirdparty.openAPI.connection.ConnectionService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ConnectionServiceImpl implements ConnectionService {
    private final WebClient webClient;

    @Override
    public ClientResponse sendGetRequest(URI uri) {
        String baseUrl = uri.getScheme() + "://" + uri.getHost();
        ClientResponse result = webClient.get().uri(uri).exchange().block();

        while (result.statusCode().is3xxRedirection()) {
            String redirectUrl = baseUrl + result.headers().header("location").get(0);
            System.out.println("redirect to : " + redirectUrl);
            result = webClient.get().uri(redirectUrl).exchange().block();
        }

        return result;
    }

    @Override
    public ClientResponse sendGetRequest(URI uri, Map<String, String> headers) {
        String baseUrl = uri.getScheme() + "://" + uri.getHost();
        WebClient.RequestHeadersSpec<?> getRequest = webClient.get().uri(uri);

        for (Map.Entry<String, String> header: headers.entrySet()) {
            getRequest.header(header.getKey(), header.getValue());
        }

        ClientResponse result = getRequest.exchange().block();

        while (result.statusCode().is3xxRedirection()) {
            String redirectUrl = baseUrl + result.headers().header("location").get(0);
            System.out.println("redirect to : " + redirectUrl);
            result = webClient.get().uri(redirectUrl).exchange().block();
        }

        return result;
    }
}
