package org.example;

import lombok.RequiredArgsConstructor;
import org.example.domain.fx.dto.response.GetNewestFxDataResponseDto;
import org.example.domain.fx.usecase.GetNewestFxDataUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fx")
@RequiredArgsConstructor
public class FxWebAdapter {
    private final GetNewestFxDataUseCase getNewestFxDataUseCase;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/price")
    public GetNewestFxDataResponseDto getNewestFxData() {
        return getNewestFxDataUseCase.execute();
    }
}
