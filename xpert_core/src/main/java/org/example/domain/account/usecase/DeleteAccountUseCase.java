package org.example.domain.account.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.account.model.Account;
import org.example.domain.account.service.CheckAccountService;
import org.example.domain.account.service.CommandAccountService;
import org.example.domain.account.service.GetAccountService;
import org.example.domain.user.model.User;
import org.example.domain.user.service.CommandUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteAccountUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final CommandAccountService commandAccountService;
    private final CommandUserService commandUserService;
    private final GetAccountService getAccountService;
    private final CheckAccountService checkAccountService;

    public void execute(UUID accountId) {
        User user = currentUserProvider.getCurrentUser();
        Account account = getAccountService.getAccountById(accountId);

        checkAccountService.checkUserIsOwnerOfAccount(user, account);

        user.setMoney(user.getMoney() + account.getMoney() + account.getInterest());
        commandUserService.saveUser(user);

        commandAccountService.deleteAccount(account);
    }
}
