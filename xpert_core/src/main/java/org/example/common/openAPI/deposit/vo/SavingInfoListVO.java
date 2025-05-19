package org.example.common.openAPI.deposit.vo;

import java.util.List;

public record SavingInfoListVO(
        List<SavingInfoListItemVO> prime,

        List<SavingInfoListItemVO> subprime
) {}
