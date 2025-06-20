package org.example.global.thirdparty.openAPI.stock.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.common.exception.general.InternalServerException;
import org.example.common.openAPI.stock.vo.GetCompanyProfileVO;
import org.example.common.openAPI.stock.vo.GetStockPriceResultVO;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GetCompanyProfileResultMapper {

    public GetCompanyProfileVO parseResultToVO(String json) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Map<String, String> result = objectMapper.readValue(json, new TypeReference<>() {});

            return new GetCompanyProfileVO(
                    (long) (Double.parseDouble(result.get("marketCapitalization")) * 1_000_000),
                    (long) (Double.parseDouble(result.get("shareOutstanding")) * 1_000_000),
                    result.get("ipo"),
                    result.get("name")
            );
        } catch (Exception e) {
            throw InternalServerException.EXCEPTION;
        }
    }
}
