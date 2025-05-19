package org.example.common.openAPI.deposit.vo;

public record DepositInfoListItemVO(
    String companyName,

    String productName,

    String type,

    double rate,

    int period
) {
}
