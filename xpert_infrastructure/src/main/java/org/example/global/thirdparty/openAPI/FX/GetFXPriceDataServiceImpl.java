package org.example.global.thirdparty.openAPI.FX;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.common.exception.general.InternalServerException;
import org.example.common.openAPI.fx.GetFXPriceService;
import org.example.common.openAPI.fx.vo.FXItemVO;
import org.example.global.thirdparty.openAPI.WebClientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetFXPriceDataServiceImpl implements GetFXPriceService {
    private final WebClientService webClientService;

    @Value("${openAPI.kr_export_import_bank.auth_key}")
    String apiServiceKey;

    @Override
    public List<FXItemVO> getFXPrice() {
        return formatResponse(webClientService.sendGetRequest(getRequestUri()));
    }

    private List<FXItemVO> formatResponse(String response) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(response, new TypeReference<>() {});
        } catch (Exception e) {
            log.error(e.getMessage());
            throw InternalServerException.EXCEPTION;
        }
    }

    private String getRequestUri() {
        return UriComponentsBuilder
                .fromUriString("https://www.koreaexim.go.kr")
                .path("/site/program/financial/exchangeJSON")
                .queryParam("authkey", "{authKey}")
                .queryParam("data", "AP01")
                .build(apiServiceKey)
                .toString();
    }
}
