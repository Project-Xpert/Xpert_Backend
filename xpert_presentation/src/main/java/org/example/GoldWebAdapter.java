package org.example;

import lombok.RequiredArgsConstructor;
import org.example.domain.gold.dto.response.GetGoldPricesResponseDto;
import org.example.domain.gold.usecase.GetGoldPriceDataUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gold")
@RequiredArgsConstructor
public class GoldWebAdapter {
    private final GetGoldPriceDataUseCase getGoldPriceDataUseCase;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/price")
    public GetGoldPricesResponseDto getGoldPriceData() {
        return getGoldPriceDataUseCase.execute();
    }
}
