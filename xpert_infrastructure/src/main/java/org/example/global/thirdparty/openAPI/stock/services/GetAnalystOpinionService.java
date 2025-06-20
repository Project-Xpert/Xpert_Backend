package org.example.global.thirdparty.openAPI.stock.services;

import lombok.RequiredArgsConstructor;
import org.example.common.openAPI.stock.vo.GetAnalystOpinionResultVO;
import org.example.global.thirdparty.openAPI.connection.ConnectionService;
import org.example.global.thirdparty.openAPI.stock.mapper.GetAnalystOpinionResultMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GetAnalystOpinionService {
    private final ConnectionService connectionService;
    private final GetAnalystOpinionResultMapper resultMapper;

    @Value("${openAPI.rapid.auth_key}")
    String apiServiceKey;

    public GetAnalystOpinionResultVO execute(String stockCode) {
        URI uri = getUri(stockCode);
        Map<String, String> headers = getHeaders();

        String apiResult = connectionService.sendGetRequest(uri, headers).bodyToMono(String.class).block();

        return resultMapper.parseJsonToVO(apiResult);
    }

    private Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();

        headers.put("X-RapidAPI-Key", apiServiceKey);
        headers.put("X-RapidAPI-Host", "apidojo-yahoo-finance-v1.p.rapidapi.com");

        return headers;
    }

    private URI getUri(String stockCode) {
        return UriComponentsBuilder
                .fromUriString("https://apidojo-yahoo-finance-v1.p.rapidapi.com")
                .path("/stock/get-recommendation-trend")
                .queryParam("symbol", stockCode)
                .build()
                .toUri();
    }
}
