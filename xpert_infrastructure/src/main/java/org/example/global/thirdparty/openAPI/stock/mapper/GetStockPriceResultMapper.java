package org.example.global.thirdparty.openAPI.stock.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.common.exception.general.InternalServerException;
import org.example.common.openAPI.stock.vo.GetStockPriceResultVO;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GetStockPriceResultMapper {

    public GetStockPriceResultVO parseResultToVO(String json) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Map<String, String> result = objectMapper.readValue(json, new TypeReference<>() {});

            return new GetStockPriceResultVO(
                Double.parseDouble(result.get("c")),
                Double.parseDouble(result.get("d")),
                Double.parseDouble(result.get("dp"))
            );
        } catch (Exception e) {
            throw InternalServerException.EXCEPTION;
        }
    }
}
