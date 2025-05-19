package org.example.domain.deposit.dto;

import org.example.common.openAPI.deposit.vo.DepositInfoListItemVO;
import org.example.common.openAPI.deposit.vo.DepositInfoListVO;
import org.example.common.openAPI.deposit.vo.SavingInfoListVO;

import java.util.List;

public record GetDepositInfoListResponseDto(
   DepositInfoListVO deposit,

   SavingInfoListVO saving
) {}