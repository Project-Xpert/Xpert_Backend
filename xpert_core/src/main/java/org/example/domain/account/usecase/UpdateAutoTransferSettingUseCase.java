package org.example.domain.account.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.account.dto.request.UpdateAutoTransferSettingRequestDto;
import org.example.domain.account.model.Account;
import org.example.domain.account.service.CheckAccountService;
import org.example.domain.account.service.CommandAccountService;
import org.example.domain.account.service.GetAccountService;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateAutoTransferSettingUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final GetAccountService getAccountService;
    private final CommandAccountService commandAccountService;
    private final CheckAccountService checkAccountService;

    public void execute(UUID accountId, UpdateAutoTransferSettingRequestDto request) {
        Account account = getAccountService.getAccountById(accountId);
        User user = currentUserProvider.getCurrentUser();

        checkAccountService.checkUserIsOwnerOfAccount(user, account);

        account.setAutoTransfer(request.autoTransfer());
        account.setAutoTransferAmount(request.autoTransferAmount());

        commandAccountService.saveAccount(account);
    }
}
