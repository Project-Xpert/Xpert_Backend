package org.example.domain.account.spi;

import org.example.domain.account.model.Account;

import java.util.Optional;
import java.util.UUID;

public interface QueryAccountPort {

    void saveAccount(Account account);

    Optional<Account> getAccountById(UUID accountId);

    void deleteAccount(Account account);
}
