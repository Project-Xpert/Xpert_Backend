package org.example.global.thirdparty.openAPI;

import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

public interface GenericDtoMapper<Dto> {

    public Dto parseResult(ClientResponse response);
}
