package org.example.domain.account.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.account.dto.response.GetAccountListResponseDto;
import org.example.domain.account.model.Account;
import org.example.domain.account.model.AccountType;
import org.example.domain.account.service.GetAccountService;
import org.example.domain.account.spi.vo.AccountListItemVO;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetAccountListUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final GetAccountService getAccountService;

    public GetAccountListResponseDto execute() {
        User user = currentUserProvider.getCurrentUser();
        List<Account> accounts = getAccountService.getAccountsByUser(user);

        List<AccountListItemVO> deposits = new ArrayList<>();
        List<AccountListItemVO> savings = new ArrayList<>();
        List<AccountListItemVO> expiredAccounts = new ArrayList<>();
        List<AccountListItemVO> overdueAccounts = new ArrayList<>();

        for (Account account: accounts) {
            if (account.getIsOverdue()) {
                overdueAccounts.add(AccountListItemVO.from(account));
            } else if (account.getExpireAt().isBefore(LocalDate.now())) {
                expiredAccounts.add(AccountListItemVO.from(account));
            } else if (account.getAccountType() == AccountType.DEPOSIT) {
                deposits.add(AccountListItemVO.from(account));
            } else {
                savings.add(AccountListItemVO.from(account));
            }
        }

        return new GetAccountListResponseDto(deposits, savings, expiredAccounts, overdueAccounts);
    }
}
