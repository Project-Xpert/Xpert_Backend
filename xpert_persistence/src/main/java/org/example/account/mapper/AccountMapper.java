package org.example.account.mapper;

import lombok.RequiredArgsConstructor;
import org.example.GenericMapper;
import org.example.account.entity.AccountJpaEntity;
import org.example.domain.account.model.Account;
import org.example.domain.user.model.User;
import org.example.user.entity.UserJpaEntity;
import org.example.user.mapper.UserMapper;
import org.example.user.repository.UserJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AccountMapper implements GenericMapper<Account, AccountJpaEntity> {
    private final UserMapper userMapper;
    private final UserJpaRepository userJpaRepository;

    @Override
    public Optional<Account> toDomain(Optional<AccountJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        AccountJpaEntity accountEntity = entity.get();
        User user = userMapper.toDomain(Optional.of(accountEntity.getUser())).get();

        return Optional.of(Account.builder()
                        .accountId(accountEntity.getAccountId())
                        .user(user)
                        .productName(accountEntity.getProductName())
                        .money(accountEntity.getMoney())
                        .interest(accountEntity.getInterest())
                        .accountType(accountEntity.getAccountType())
                        .interestType(accountEntity.getInterestType())
                        .rate(accountEntity.getRate())
                        .autoTransfer(accountEntity.getAutoTransfer())
                        .expireAt(accountEntity.getExpireAt())
                        .build());
    }

    @Override
    public AccountJpaEntity toEntity(Account domain) {
        UserJpaEntity userEntity = userJpaRepository.findById(domain.getUser().getUserId()).get();

        return new AccountJpaEntity(
                domain.getAccountId(),
                userEntity,
                domain.getProductName(),
                domain.getMoney(),
                domain.getInterest(),
                domain.getAccountType(),
                domain.getInterestType(),
                domain.getRate(),
                domain.getAutoTransfer(),
                domain.getExpireAt()
        );
    }
}
