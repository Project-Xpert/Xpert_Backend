package org.example.domain.account.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.example.common.annotation.ValidEnum;
import org.example.domain.account.model.AccountType;
import org.example.domain.account.model.InterestType;
import org.hibernate.validator.constraints.Length;

public record CreateAccountRequestDto(

    @NotBlank
    @Length(max = 30)
    String productName,

    @NotBlank
    @Length(max = 20)
    String companyName,

    @Min(1)
    int money,

    @ValidEnum(enumClass = AccountType.class)
    AccountType accountType,

    @ValidEnum(enumClass = InterestType.class)
    InterestType interestType,

    @Min(0)
    Double rate,

    Boolean autoTransfer,

    @Min(1)
    int expirePeriod
) {
}
