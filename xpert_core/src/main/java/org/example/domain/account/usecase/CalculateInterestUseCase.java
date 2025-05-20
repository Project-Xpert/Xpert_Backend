package org.example.domain.account.usecase;

import lombok.RequiredArgsConstructor;
import org.example.domain.account.model.Account;
import org.example.domain.account.model.InterestType;
import org.example.domain.account.service.CommandAccountService;
import org.example.domain.account.service.GetAccountService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CalculateInterestUseCase {
    private final GetAccountService getAccountService;
    private final CommandAccountService commandAccountService;

//    @Scheduled(cron = "0 0 6 1/1 * ?")
    @Scheduled(cron = "0 0/1 * 1/1 * ?")
    public void execute() {
        int dayOfWeek = LocalDate.now().getDayOfWeek().getValue();
        List<Account> accountList = getAccountService.getAccountsByDayOfWeek(dayOfWeek);

        for (Account account: accountList) {
            double weekRate = account.getRate() / 100 / 12;
            int baseMoney = account.getMoney();

            if (account.getInterestType().equals(InterestType.COMPOUND)) {
                baseMoney += account.getInterest();
            }

            account.setInterest(account.getInterest() + (int) Math.round(baseMoney * weekRate));
            commandAccountService.saveAccount(account);
        }
    }
}
