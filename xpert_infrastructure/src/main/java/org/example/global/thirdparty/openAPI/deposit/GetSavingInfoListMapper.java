package org.example.global.thirdparty.openAPI.deposit;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.common.exception.general.InternalServerException;
import org.example.common.openAPI.deposit.vo.DepositInfoListItemVO;
import org.example.common.openAPI.deposit.vo.SavingInfoListItemVO;
import org.example.global.thirdparty.openAPI.GenericDtoMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class GetSavingInfoListMapper implements GenericDtoMapper<List<SavingInfoListItemVO>> {

    @Override
    public List<SavingInfoListItemVO> parseResult(ClientResponse response) {
        String parsedResponse = response.bodyToMono(String.class).block();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode rootNode = objectMapper.readTree(parsedResponse);
            JsonNode resultNode = rootNode.get("result");
            JsonNode optionNodes = resultNode.get("optionList");
            JsonNode baseInfoNodes = resultNode.get("baseList");

            List<SavingInfoListItemVO> savingInfoItems = new ArrayList<>();

            int repeatCnt = Math.min(resultNode.get("total_count").asInt(), 50);
            for (int i = 0; i < repeatCnt; i++) {
                JsonNode optionNode = optionNodes.get(i);
                JsonNode baseInfoNode = baseInfoNodes.get(i);

                savingInfoItems.add(new SavingInfoListItemVO(
                        baseInfoNode.get("kor_co_nm").asText()
                                .replaceAll("한국스탠다드차타드은행", "SC제일은행"),
                        baseInfoNode.get("fin_prdt_nm").asText()
                                .replaceAll("\n", "")
                                .replaceAll("\\([^)]+\\)", ""),
                        optionNode.get("intr_rate_type_nm").asText(),
                        optionNode.get("rsrv_type_nm").asText(),
                        optionNode.get("intr_rate").asDouble(),
                        optionNode.get("save_trm").asInt()
                ));
            }

            return savingInfoItems;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw InternalServerException.EXCEPTION;
        }
    }
}
