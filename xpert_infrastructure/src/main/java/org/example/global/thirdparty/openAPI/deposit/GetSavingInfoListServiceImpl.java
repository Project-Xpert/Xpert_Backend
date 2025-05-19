package org.example.global.thirdparty.openAPI.deposit;

import lombok.RequiredArgsConstructor;
import org.example.common.openAPI.deposit.GetSavingInfoListService;
import org.example.common.openAPI.deposit.vo.SavingInfoListItemVO;
import org.example.common.openAPI.deposit.vo.SavingInfoListVO;
import org.example.global.thirdparty.openAPI.connection.ConnectionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GetSavingInfoListServiceImpl implements GetSavingInfoListService {
    private final ConnectionService connectionService;
    private final GetSavingInfoListMapper getSavingInfoListMapper;

    @Value("${openAPI.kr_financial_supervisory_service.auth_key}")
    private String authKey;

    @Override
    public SavingInfoListVO execute() {
        List<SavingInfoListItemVO> primeList = getSavingInfoListMapper.parseResult(
                connectionService.sendGetRequest(getUri("020000"))
        );

        List<SavingInfoListItemVO> subprimeList = getSavingInfoListMapper.parseResult(
                connectionService.sendGetRequest(getUri("030300"))
        );

        return new SavingInfoListVO(primeList, subprimeList);
    }

    private URI getUri(String financialCode) {
        return UriComponentsBuilder
                .fromUriString("https://finlife.fss.or.kr/finlifeapi/savingProductsSearch.json")
                .queryParam("auth", "{authKey}")
                .queryParam("topFinGrpNo", "{financialCode}")
                .queryParam("pageNo", "1")
                .build(authKey, financialCode);
    }
}
