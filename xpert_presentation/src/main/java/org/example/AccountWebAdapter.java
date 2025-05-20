package org.example;

import lombok.RequiredArgsConstructor;
import org.example.domain.account.dto.request.CreateAccountRequestDto;
import org.example.domain.account.dto.response.GetAccountInfoListResponseDto;
import org.example.domain.account.usecase.CreateAccountUseCase;
import org.example.domain.account.usecase.DeleteAccountUseCase;
import org.example.domain.account.usecase.GetAccountInfoListUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountWebAdapter {
    private final GetAccountInfoListUseCase getAccountInfoListUseCase;
    private final CreateAccountUseCase createAccountUseCase;
    private final DeleteAccountUseCase deleteAccountUseCase;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/info")
    public GetAccountInfoListResponseDto getAccountInfoList() {
        return getAccountInfoListUseCase.execute();
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
}
