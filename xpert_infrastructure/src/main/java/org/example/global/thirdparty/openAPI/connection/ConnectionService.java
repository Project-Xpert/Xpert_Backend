package org.example.global.thirdparty.openAPI.connection;

import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Map;

public interface ConnectionService {

    ClientResponse sendGetRequest(URI uri);

    ClientResponse sendGetRequest(URI uri, Map<String, String> headers);
}
