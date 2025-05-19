package org.example;

import lombok.RequiredArgsConstructor;
import org.example.domain.account.dto.GetAccountInfoListResponseDto;
import org.example.domain.account.usecase.GetAccountInfoListUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountWebAdapter {
    private final GetAccountInfoListUseCase getAccountInfoListUseCase;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/info")
    public GetAccountInfoListResponseDto getAccountInfoList() {
        return getAccountInfoListUseCase.execute();
    }
}
