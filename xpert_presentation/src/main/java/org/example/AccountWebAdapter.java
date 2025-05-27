package org.example;

import lombok.RequiredArgsConstructor;
import org.example.domain.account.dto.request.CreateAccountRequestDto;
import org.example.domain.account.dto.request.UpdateAutoTransferSettingRequestDto;
import org.example.domain.account.dto.response.GetAccountDetailResponseDto;
import org.example.domain.account.dto.response.GetAccountInfoListResponseDto;
import org.example.domain.account.dto.response.GetAccountListResponseDto;
import org.example.domain.account.usecase.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountWebAdapter {
    private final UpdateAutoTransferSettingUseCase updateAutoTransferSettingUseCase;
    private final GetAccountInfoListUseCase getAccountInfoListUseCase;
    private final GetAccountDetailUseCase accountDetailUseCase;
    private final GetAccountListUseCase getAccountListUseCase;
    private final CreateAccountUseCase createAccountUseCase;
    private final DeleteAccountUseCase deleteAccountUseCase;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/info")
    public GetAccountInfoListResponseDto getAccountInfoList() {
        return getAccountInfoListUseCase.execute();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public GetAccountListResponseDto getAccountList() {
        return getAccountListUseCase.execute();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{accountId}")
    public GetAccountDetailResponseDto getAccountDetail(@PathVariable UUID accountId) {
        return accountDetailUseCase.execute(accountId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createAccount(@Validated @RequestBody CreateAccountRequestDto request) {
        createAccountUseCase.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{accountId}")
    public void deleteAccount(@PathVariable UUID accountId) {
        deleteAccountUseCase.execute(accountId);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/auto-transfer/{accountId}")
    public void updateAutoTransferSetting(
        @PathVariable UUID accountId,
        @Validated @RequestBody UpdateAutoTransferSettingRequestDto request
    ) {
       updateAutoTransferSettingUseCase.execute(accountId, request);
    }
}
