package org.example.domain.account.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.account.model.Account;
import org.example.domain.account.service.CommandAccountService;
import org.example.domain.account.spi.QueryAccountPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandAccountServiceImpl implements CommandAccountService {
    private final QueryAccountPort queryAccountPort;

    @Override
    public void saveAccount(Account account) {
        queryAccountPort.saveAccount(account);
    }
}
