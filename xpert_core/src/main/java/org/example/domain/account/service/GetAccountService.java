package org.example.domain.account.service;

import org.example.domain.account.model.Account;

import java.time.DayOfWeek;
import java.util.List;
import java.util.UUID;

public interface GetAccountService {

    Account getAccountById(UUID accountId);

    List<Account> getAccountsByDayOfWeek(int dayOfWeek);
}
