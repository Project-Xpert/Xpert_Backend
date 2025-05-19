package org.example.domain.deposit.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.openAPI.deposit.GetDepositInfoListService;
import org.example.common.openAPI.deposit.GetSavingInfoListService;
import org.example.common.openAPI.deposit.vo.DepositInfoListVO;
import org.example.common.openAPI.deposit.vo.SavingInfoListVO;
import org.example.domain.deposit.dto.GetDepositInfoListResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class GetDepositInfoListUseCase {
    private final GetDepositInfoListService getDepositInfoListService;
    private final GetSavingInfoListService getSavingInfoListService;

    public GetDepositInfoListResponseDto execute() {
        DepositInfoListVO depositInfoList = getDepositInfoListService.execute();
        SavingInfoListVO savingInfoList = getSavingInfoListService.execute();

        return new GetDepositInfoListResponseDto(depositInfoList, savingInfoList);
    }
}
