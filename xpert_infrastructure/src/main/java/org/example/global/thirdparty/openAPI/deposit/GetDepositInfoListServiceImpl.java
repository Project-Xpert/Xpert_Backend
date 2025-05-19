package org.example.global.thirdparty.openAPI.deposit;

import lombok.RequiredArgsConstructor;
import org.example.common.openAPI.deposit.GetDepositInfoListService;
import org.example.common.openAPI.deposit.vo.DepositInfoListItemVO;
import org.example.common.openAPI.deposit.vo.DepositInfoListVO;
import org.example.domain.deposit.dto.GetDepositInfoListResponseDto;
import org.example.global.thirdparty.openAPI.connection.ConnectionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GetDepositInfoListServiceImpl implements GetDepositInfoListService {
    private final ConnectionService connectionService;
    private final GetDepositInfoListMapper getDepositInfoListMapper;

    @Value("${openAPI.kr_financial_supervisory_service.auth_key}")
    private String authKey;

    @Override
    public DepositInfoListVO execute() {
        List<DepositInfoListItemVO> primeList = getDepositInfoListMapper.parseResult(
                connectionService.sendGetRequest(getUri("020000"))
        );

        List<DepositInfoListItemVO> subprimeList = getDepositInfoListMapper.parseResult(
                connectionService.sendGetRequest(getUri("030300"))
        );

        return new DepositInfoListVO(primeList, subprimeList);
    }

    private URI getUri(String financialCode) {
        return UriComponentsBuilder
                .fromUriString("https://finlife.fss.or.kr/finlifeapi/depositProductsSearch.json")
                .queryParam("auth", "{authKey}")
                .queryParam("topFinGrpNo", "{financialCode}")
                .queryParam("pageNo", "1")
                .build(authKey, financialCode);
    }
}
