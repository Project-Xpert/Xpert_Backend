package org.example.common.openAPI.deposit.vo;

public record SavingInfoListItemVO(
        String companyName,

        String productName,

        String type,

        String saveType,

        double rate,

        int period
) { }
