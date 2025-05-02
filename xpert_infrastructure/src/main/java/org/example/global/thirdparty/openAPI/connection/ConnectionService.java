package org.example.global.thirdparty.openAPI.connection;

import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;

public interface ConnectionService {

    WebClient.ResponseSpec sendGetRequest(URI uri);
}
