package org.example.account;

import lombok.RequiredArgsConstructor;
import org.example.account.mapper.AccountMapper;
import org.example.account.repository.AccountJpaRepository;
import org.example.domain.account.model.Account;
import org.example.domain.account.spi.QueryAccountPort;
import org.example.domain.user.model.User;
import org.example.user.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AccountPersistenceAdapter implements QueryAccountPort {
    private final AccountJpaRepository accountJpaRepository;
    private final AccountMapper accountMapper;
    private final UserMapper userMapper;

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

    @Override
    public List<Account> getAccountsByUser(User user) {
        return accountJpaRepository.getAccountJpaEntitiesByUser(userMapper.toEntity(user)).stream()
                .map(account -> accountMapper.toDomain(Optional.of(account)).get())
                .toList();
    }

    @Override
    public List<Account> getAccountsNeedToDelete() {
        int deleteDay = LocalDate.now().minusDays(3).getDayOfWeek().getValue();

        return accountJpaRepository.getAccountsNeedToDelete(deleteDay).stream()
                .map(account -> accountMapper.toDomain(Optional.of(account)).get())
                .toList();
    }
}
