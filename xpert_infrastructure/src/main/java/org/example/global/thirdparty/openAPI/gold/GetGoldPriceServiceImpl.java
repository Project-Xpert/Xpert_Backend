package org.example.global.thirdparty.openAPI.gold;

import lombok.RequiredArgsConstructor;
import org.example.common.openAPI.gold.GetGoldPriceService;
import org.example.common.openAPI.gold.vo.GoldAPIResponseVO;
import org.example.common.openAPI.gold.vo.GoldBodyVO;
import org.example.common.openAPI.gold.vo.GoldItemVO;
import org.example.domain.gold.dto.response.GetGoldPricesResponseDto;
import org.example.global.thirdparty.openAPI.connection.ConnectionService;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetGoldPriceServiceImpl implements GetGoldPriceService {
    private final ConnectionService connectionService;
    private final GoldPriceResultMapper mapper;

    @Value("${openAPI.kr_data.service_key}")
    String apiServiceKey;

    @Override
    public GetGoldPricesResponseDto getGoldPriceData() {
        URI uri = getRequestUri();

        GoldAPIResponseVO goldAPIResponse = mapper.parseResult(connectionService.sendGetRequest(uri));
        GoldBodyVO body = goldAPIResponse.response().get("body");

        List<GoldItemVO> results = new ArrayList<>(body.items().get("item"));

        return GetGoldPricesResponseDto.builder()
                        .goldPrices(results)
                        .build();
    }

    private URI getRequestUri() {
        String startDate = LocalDate.now().minusYears(3).toString().replace("-", "");
        String endDate = LocalDate.now().toString().replace("-", "");

        return UriComponentsBuilder
                .fromUriString("https://apis.data.go.kr")
                .path("/1160100/service/GetGeneralProductInfoService/getGoldPriceInfo")
                .queryParam("serviceKey", "{serviceKey}")
                .queryParam("beginBasDt", startDate)
                .queryParam("endBasDt", endDate)
                .queryParam("resultType", "json")
                .queryParam("numOfRows", "1000")
                .queryParam("itmsNm", "금 99.99_1Kg")
                .buildAndExpand(apiServiceKey)
                .encode()
                .toUri();
    }
}
