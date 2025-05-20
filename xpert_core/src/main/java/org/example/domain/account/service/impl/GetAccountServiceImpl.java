package org.example.domain.account.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.account.exception.AccountNotFoundException;
import org.example.domain.account.model.Account;
import org.example.domain.account.service.GetAccountService;
import org.example.domain.account.spi.QueryAccountPort;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetAccountServiceImpl implements GetAccountService {
    private final QueryAccountPort queryAccountPort;

    @Override
    public Account getAccountById(UUID accountId) {
        return queryAccountPort.getAccountById(accountId)
                .orElseThrow(() -> AccountNotFoundException.EXCEPTION);
    }

    @Override
    public List<Account> getAccountsByDayOfWeek(int dayOfWeek) {
        return queryAccountPort.getAccountsByDayOfWeek(dayOfWeek);
    }
}
