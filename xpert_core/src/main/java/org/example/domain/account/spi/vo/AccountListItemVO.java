package org.example.domain.account.spi.vo;

import org.example.domain.account.model.Account;
import org.example.domain.account.model.AccountType;

import java.util.UUID;

public record AccountListItemVO(
    UUID accountId,

    String companyName,

    String productName,

    AccountType accountType,

    int totalMoney
) {
    public static AccountListItemVO from(Account account) {
        return new AccountListItemVO(
                account.getAccountId(),
                account.getCompanyName(),
                account.getProductName(),
                account.getAccountType(),
                account.getMoney() + account.getInterest()
        );
    }
}
