package org.example.global.thirdparty.openAPI.stock.services;

import lombok.RequiredArgsConstructor;
import org.example.common.openAPI.stock.vo.GetStockPriceResultVO;
import org.example.global.thirdparty.openAPI.connection.ConnectionService;
import org.example.global.thirdparty.openAPI.stock.mapper.GetStockPriceResultMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class GetStockPriceService {
    private final ConnectionService connectionService;
    private final GetStockPriceResultMapper resultMapper;

    @Value("${openAPI.finnhub.auth_key}")
    String apiServiceKey;

    public GetStockPriceResultVO execute(String stockCode) {
        URI uri = getUri(stockCode);
        String apiResult = connectionService.sendGetRequest(uri).bodyToMono(String.class).block();

        return resultMapper.parseResultToVO(apiResult);
    }

    private URI getUri(String stockCode) {
        return UriComponentsBuilder
                .fromUriString("https://finnhub.io")
                .path("/api/v1/quote")
                .queryParam("symbol", stockCode)
                .queryParam("token", "{token}")
                .build(apiServiceKey);
    }
}
