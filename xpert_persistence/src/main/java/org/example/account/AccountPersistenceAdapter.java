package org.example.account;

import lombok.RequiredArgsConstructor;
import org.example.account.mapper.AccountMapper;
import org.example.account.repository.AccountJpaRepository;
import org.example.domain.account.model.Account;
import org.example.domain.account.spi.QueryAccountPort;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountPersistenceAdapter implements QueryAccountPort {
    private final AccountJpaRepository accountJpaRepository;
    private final AccountMapper accountMapper;

    @Override
    public void saveAccount(Account account) {
        accountJpaRepository.save(
                accountMapper.toEntity(account)
        );
    }
}
