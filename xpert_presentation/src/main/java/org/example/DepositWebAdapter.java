package org.example;

import lombok.RequiredArgsConstructor;
import org.example.domain.deposit.dto.GetDepositInfoListResponseDto;
import org.example.domain.deposit.usecase.GetDepositInfoListUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deposit")
@RequiredArgsConstructor
public class DepositWebAdapter {
    private final GetDepositInfoListUseCase getDepositInfoListUseCase;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/info")
    public GetDepositInfoListResponseDto getDepositInfoList() {
        return getDepositInfoListUseCase.execute();
    }
}
