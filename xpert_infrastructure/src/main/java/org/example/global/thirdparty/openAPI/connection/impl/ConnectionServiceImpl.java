package org.example.global.thirdparty.openAPI.connection.impl;

import lombok.RequiredArgsConstructor;
import org.example.global.thirdparty.openAPI.connection.ConnectionService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;

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
}
