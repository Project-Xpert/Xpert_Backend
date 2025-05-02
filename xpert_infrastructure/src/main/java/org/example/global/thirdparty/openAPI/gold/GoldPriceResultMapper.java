package org.example.global.thirdparty.openAPI.gold;

import org.example.common.openAPI.gold.vo.GoldAPIResponseVO;
import org.example.global.thirdparty.openAPI.GenericDtoMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class GoldPriceResultMapper implements GenericDtoMapper<GoldAPIResponseVO> {

    @Override
    public GoldAPIResponseVO parseResult(WebClient.ResponseSpec response) {
        return response.bodyToMono(GoldAPIResponseVO.class).block();
    }
}
