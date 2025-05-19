package org.example.common.openAPI.deposit.vo;

import java.util.List;

public record DepositInfoListVO(
        List<DepositInfoListItemVO> prime,

        List<DepositInfoListItemVO> subprime
) {}
