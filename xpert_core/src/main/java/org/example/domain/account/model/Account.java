package org.example.domain.account.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.domain.user.model.User;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
public class Account {
    private UUID accountId;

    private User user;

    private String productName;

    private String companyName;

    private int money;

    private int interest;

    private AccountType accountType;

    private InterestType interestType;

    private Double rate;

    private Boolean autoTransfer;

    private int autoTransferAmount;

    private int day;

    private int expireAt;

    private Boolean isOverdue;
}