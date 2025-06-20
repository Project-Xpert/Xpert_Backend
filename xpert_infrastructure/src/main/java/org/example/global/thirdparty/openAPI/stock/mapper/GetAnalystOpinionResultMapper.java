package org.example.global.thirdparty.openAPI.stock.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.common.exception.general.InternalServerException;
import org.example.common.openAPI.stock.vo.GetAnalystOpinionResultVO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Component
public class GetAnalystOpinionResultMapper {
    ObjectMapper objectMapper = new ObjectMapper();
    Pattern pattern = Pattern.compile("\\{\\s*\"period\"\\s*:\\s*\"0m\"\\s*,[^}]*\\}");

    public GetAnalystOpinionResultVO parseJsonToVO(String json) {
        Matcher matcher = pattern.matcher(json);

        try {
            if (!matcher.find()) return new GetAnalystOpinionResultVO(new int[]{0, 0, 0, 0, 0});

            Map<String, String> result = objectMapper.readValue(matcher.group(), new TypeReference<>() {});
            int[] opinions = {
                    Integer.parseInt(result.get("strongSell")),
                    Integer.parseInt(result.get("sell")),
                    Integer.parseInt(result.get("hold")),
                    Integer.parseInt(result.get("buy")),
                    Integer.parseInt(result.get("strongBuy"))
            };

            return new GetAnalystOpinionResultVO(opinions);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw InternalServerException.EXCEPTION;
        }
    }
}
