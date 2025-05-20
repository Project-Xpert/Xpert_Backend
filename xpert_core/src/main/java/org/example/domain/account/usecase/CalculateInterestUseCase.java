package org.example.domain.account.usecase;

import lombok.RequiredArgsConstructor;
import org.example.domain.account.model.Account;
import org.example.domain.account.model.AccountType;
import org.example.domain.account.model.InterestType;
import org.example.domain.account.service.CommandAccountService;
import org.example.domain.account.service.GetAccountService;
import org.example.domain.user.model.User;
import org.example.domain.user.service.CommandUserService;
import org.example.domain.user.service.GetUserService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CalculateInterestUseCase {
    private final GetUserService getUserService;
    private final GetAccountService getAccountService;
    private final CommandUserService commandUserService;
    private final CommandAccountService commandAccountService;

    @Scheduled(cron = "0 0 6 1/1 * ?")
    public void execute() {
        int dayOfWeek = LocalDate.now().getDayOfWeek().getValue();
        List<Account> accountList = getAccountService.getAccountsByDayOfWeek(dayOfWeek);

        for (Account account: accountList) {
            if (account.getInterestType().equals(InterestType.COMPOUND)) {
                boolean autoTransferIsValid = account.getUser().getMoney() >= account.getAutoTransferAmount();
                boolean isFixedSavingsAccount = account.getAccountType().equals(AccountType.FIXED_SAVINGS);

                if (account.getAutoTransfer() && autoTransferIsValid || isFixedSavingsAccount) {
                    transferMoney(account);
                } else {
                    account.setIsOverdue(true);
                    commandAccountService.saveAccount(account);
                    continue;
                }
            }

            account.setInterest(calculateInterest(account));

            commandAccountService.saveAccount(account);
        }
    }

    private void transferMoney(Account account) {
        User user = getUserService.getUserByUserId(account.getUser().getUserId());
        user.setMoney(user.getMoney() - account.getAutoTransferAmount());
        account.setMoney(account.getAutoTransferAmount());
        commandUserService.saveUser(user);
    }

    private int calculateInterest(Account account) {
        double weekRate = account.getRate() / 100 / 12;
        int baseMoney = account.getMoney();

        if (account.getInterestType().equals(InterestType.COMPOUND)) {
            baseMoney += account.getInterest();
        }

        return account.getInterest() + (int) Math.round(baseMoney * weekRate);
    }
}
