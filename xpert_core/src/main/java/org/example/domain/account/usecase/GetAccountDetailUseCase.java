package org.example.domain.account.usecase;

import lombok.RequiredArgsConstructor;
import org.example.domain.account.dto.response.GetAccountDetailResponseDto;
import org.example.domain.account.model.Account;
import org.example.domain.account.service.GetAccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetAccountDetailUseCase {
    private final GetAccountService getAccountService;

    public GetAccountDetailResponseDto execute(UUID accountId) {
        Account account = getAccountService.getAccountById(accountId);

        return GetAccountDetailResponseDto.from(account);
    }
}
