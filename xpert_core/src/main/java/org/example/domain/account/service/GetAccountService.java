package org.example.domain.account.service;

import org.example.domain.account.model.Account;

import java.util.UUID;

public interface GetAccountService {

    Account getAccountById(UUID accountId);
}
