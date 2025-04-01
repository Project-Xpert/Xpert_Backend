package org.example.global.thirdparty.openAPI;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.common.exception.general.InternalServerException;
import org.example.common.exception.general.ServiceUnavailableException;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class WebClientService {
    private final WebClient webClient;

    public String sendGetRequest(String uri) {
        try {
            return webClient.get()
                    .uri(uri)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw ServiceUnavailableException.EXCEPTION;
        }
    }
}
