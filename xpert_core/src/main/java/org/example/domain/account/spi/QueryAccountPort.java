package org.example.domain.account.spi;

import org.example.domain.account.model.Account;
import org.example.domain.user.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface QueryAccountPort {

    void saveAccount(Account account);

    Optional<Account> getAccountById(UUID accountId);

    void deleteAccount(Account account);

    List<Account> getAccountsByDayOfWeek(int dayOfWeek);

    List<Account> getAccountsByUser(User user);

    List<Account> getAccountsNeedToDelete();
}
