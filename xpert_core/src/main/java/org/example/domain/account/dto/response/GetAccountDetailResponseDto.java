package org.example.domain.account.dto.response;

import org.example.domain.account.model.Account;
import org.example.domain.account.model.AccountType;
import org.example.domain.account.model.InterestType;

public record GetAccountDetailResponseDto(
    String productName,

    String companyName,

    int money,

    InterestType interestType,

    AccountType accountType,

    Double rate,

    int autoTransferAmount,

    boolean autoTransfer,

    int expirePeriod
) {
    public static GetAccountDetailResponseDto from(Account account) {
        return new GetAccountDetailResponseDto(
                account.getProductName(),
                account.getCompanyName(),
                account.getMoney() + account.getInterest(),
                account.getInterestType(),
                account.getAccountType(),
                account.getRate(),
                account.getAutoTransferAmount(),
                account.getAutoTransfer(),
                0
        );
    }
}
