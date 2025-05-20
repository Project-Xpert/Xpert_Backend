package org.example.domain.account.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.openAPI.deposit.GetDepositInfoListService;
import org.example.common.openAPI.deposit.GetSavingInfoListService;
import org.example.common.openAPI.deposit.vo.DepositInfoListVO;
import org.example.common.openAPI.deposit.vo.SavingInfoListVO;
import org.example.domain.account.dto.response.GetAccountInfoListResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class GetAccountInfoListUseCase {
    private final GetDepositInfoListService getDepositInfoListService;
    private final GetSavingInfoListService getSavingInfoListService;

    public GetAccountInfoListResponseDto execute() {
        DepositInfoListVO depositInfoList = getDepositInfoListService.execute();
        SavingInfoListVO savingInfoList = getSavingInfoListService.execute();

        return new GetAccountInfoListResponseDto(depositInfoList, savingInfoList);
    }
}
