package org.example.global.thirdparty.openAPI.gold;

import org.example.common.openAPI.gold.vo.GoldAPIResponseVO;
import org.example.common.openAPI.gold.vo.GoldItemVO;
import org.example.global.thirdparty.openAPI.GenericDtoMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;

@Component
public class GoldPriceResultMapper implements GenericDtoMapper<List<GoldItemVO>> {

    @Override
    public List<GoldItemVO> parseResult(ClientResponse response) {
        return Objects.requireNonNull(response.bodyToMono(GoldAPIResponseVO.class).block())
                .response().get("body")
                .items().get("item");
    }
}
