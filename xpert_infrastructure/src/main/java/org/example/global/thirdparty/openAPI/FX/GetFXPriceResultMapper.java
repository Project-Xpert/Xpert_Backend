package org.example.global.thirdparty.openAPI.FX;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.common.exception.general.InternalServerException;
import org.example.common.openAPI.fx.vo.FXItemVO;
import org.example.global.thirdparty.openAPI.GenericDtoMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Component
public class GetFXPriceResultMapper implements GenericDtoMapper<List<FXItemVO>> {

    @Override
    public List<FXItemVO> parseResult(ClientResponse response) {
        ObjectMapper mapper = new ObjectMapper();
        String parsedResponse = response.bodyToMono(String.class).block();

        if (Objects.equals(parsedResponse, "[]")) {
            return new ArrayList<>();
        }

        try {
            return mapper.readValue(parsedResponse, new TypeReference<>() {});
        } catch (Exception e) {
            log.error(e.getMessage());
            throw InternalServerException.EXCEPTION;
        }
    }
}
