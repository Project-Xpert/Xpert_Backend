package org.example.domain.account.service;

import org.example.domain.account.model.Account;

public interface CommandAccountService {
    void saveAccount(Account account);

    void deleteAccount(Account account);
}
