package org.example.domain.account.dto.response;

import org.example.common.openAPI.deposit.vo.DepositInfoListVO;
import org.example.common.openAPI.deposit.vo.SavingInfoListVO;

public record GetAccountInfoListResponseDto(
   DepositInfoListVO deposit,

   SavingInfoListVO saving
) {}