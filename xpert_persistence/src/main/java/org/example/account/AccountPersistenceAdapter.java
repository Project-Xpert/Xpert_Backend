package org.example.account;

import lombok.RequiredArgsConstructor;
import org.example.account.mapper.AccountMapper;
import org.example.account.repository.AccountJpaRepository;
import org.example.domain.account.model.Account;
import org.example.domain.account.spi.QueryAccountPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @Override
    public Optional<Account> getAccountById(UUID accountId) {
        return accountMapper.toDomain(
                accountJpaRepository.findById(accountId)
        );
    }

    @Override
    public void deleteAccount(Account account) {
        accountJpaRepository.delete(
                accountMapper.toEntity(account)
        );
    }

    @Override
    public List<Account> getAccountsByDayOfWeek(int dayOfWeek) {
        return accountJpaRepository.getAccountJpaEntitiesByDay(dayOfWeek).stream()
                .map(account -> accountMapper.toDomain(Optional.of(account)).get())
                .toList();
    }
}
