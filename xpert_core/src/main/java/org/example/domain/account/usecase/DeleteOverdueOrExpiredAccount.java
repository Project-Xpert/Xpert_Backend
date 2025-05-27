package org.example.domain.account.usecase;


import lombok.RequiredArgsConstructor;
import org.example.domain.account.model.Account;
import org.example.domain.account.service.CommandAccountService;
import org.example.domain.account.service.GetAccountService;
import org.example.domain.user.model.User;
import org.example.domain.user.service.CommandUserService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteOverdueOrExpiredAccount {
    private final CommandAccountService commandAccountService;
    private final CommandUserService commandUserService;
    private final GetAccountService getAccountService;

    @Scheduled(cron = "0 0 6 1/1 * ?")
    public void execute() {
        List<Account> accounts = getAccountService.getAccountsNeedToDelete();

        for (Account account: accounts) {
            User accountOwner = account.getUser();

            accountOwner.setMoney(
                    accountOwner.getMoney() +
                    accountOwner.getMoney() +
                    account.getInterest()
            );

            commandUserService.saveUser(accountOwner);
            commandAccountService.deleteAccount(account);
        }
    }
}
