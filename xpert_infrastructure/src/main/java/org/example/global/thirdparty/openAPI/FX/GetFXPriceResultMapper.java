package org.example.global.thirdparty.openAPI.FX;

import org.example.global.thirdparty.openAPI.GenericDtoMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class GetFXPriceResultMapper implements GenericDtoMapper<String> {

    @Override
    public String parseResult(WebClient.ResponseSpec response) {
        System.out.println(response.bodyToMono(String.class).block());
        return response.bodyToMono(String.class).block();
    }
}
