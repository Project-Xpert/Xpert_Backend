package org.example.domain.account.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.account.dto.request.CreateAccountRequestDto;
import org.example.domain.account.model.Account;
import org.example.domain.account.service.CommandAccountService;
import org.example.domain.user.model.User;
import org.example.domain.user.service.CommandUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateAccountUseCase {
    private final CommandUserService commandUserService;
    private final CurrentUserProvider currentUserProvider;
    private final CommandAccountService commandAccountService;

    public void execute(CreateAccountRequestDto request) {
        User user = currentUserProvider.getCurrentUser();

        LocalDate expireAt = LocalDate.now().plusWeeks(request.expirePeriod());

        user.setMoney(user.getMoney() - request.money());
        commandUserService.saveUser(user);

        commandAccountService.saveAccount(Account.builder()
                        .user(user)
                        .productName(request.productName())
                        .companyName(request.companyName())
                        .money(request.money())
                        .accountType(request.accountType())
                        .interestType(request.interestType())
                        .rate(request.rate())
                        .autoTransfer(request.autoTransfer())
                        .day(LocalDate.now().getDayOfMonth())
                        .expireAt(expireAt)
                        .build());
    }
}
