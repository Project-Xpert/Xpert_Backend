package org.example.global.thirdparty.openAPI.connection.impl;

import lombok.RequiredArgsConstructor;
import org.example.global.thirdparty.openAPI.connection.ConnectionService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class ConnectionServiceImpl implements ConnectionService {
    private final WebClient webClient;

    @Override
    public WebClient.ResponseSpec sendGetRequest(URI uri) {
        return webClient.get().uri(uri).retrieve();
    }
}
