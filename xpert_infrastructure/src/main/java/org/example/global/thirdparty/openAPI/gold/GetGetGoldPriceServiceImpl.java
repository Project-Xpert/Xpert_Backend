package org.example.global.thirdparty.openAPI.gold;

import lombok.RequiredArgsConstructor;
import org.example.common.openAPI.gold.GetGoldPriceService;
import org.example.common.openAPI.gold.vo.GoldAPIResponseVO;
import org.example.common.openAPI.gold.vo.GoldBodyVO;
import org.example.common.openAPI.gold.vo.GoldItemVO;
import org.example.domain.gold.dto.response.GetGoldPricesResponseDto;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetGetGoldPriceServiceImpl implements GetGoldPriceService {

    @Value("${openAPI.kr_data.service_key}")
    String apiServiceKey;

    @Override
    public GetGoldPricesResponseDto getGoldPriceData() {
        URI uri = getRequestUri(1);

        GoldBodyVO body = getGoldPrice(uri).response().get("body");

        List<GoldItemVO> results = new ArrayList<>(body.items().get("item"));

        return GetGoldPricesResponseDto.builder()
                        .goldPrices(results)
                        .build();
    }

    private GoldAPIResponseVO getGoldPrice(URI uri) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<?> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(uri, HttpMethod.GET, entity, GoldAPIResponseVO.class).getBody();
    }

    private URI getRequestUri(int pageNum) {
        String startDate = LocalDate.now().minusYears(3).toString().replace("-", "");
        String endDate = LocalDate.now().toString().replace("-", "");

        return UriComponentsBuilder
                .fromUriString("https://apis.data.go.kr")
                .path("/1160100/service/GetGeneralProductInfoService/getGoldPriceInfo")
                .queryParam("serviceKey", "{serviceKey}")
                .queryParam("pageNo", String.valueOf(pageNum))
                .queryParam("beginBasDt", startDate)
                .queryParam("endBasDt", endDate)
                .queryParam("resultType", "json")
                .queryParam("numOfRows", "1000")
                .queryParam("itmsNm", "금 99.99_1Kg")
                .build(apiServiceKey);
    }
}
