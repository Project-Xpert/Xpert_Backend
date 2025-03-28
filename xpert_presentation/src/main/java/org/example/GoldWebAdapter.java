package org.example;

import lombok.RequiredArgsConstructor;
import org.example.domain.gold.dto.request.BuyGoldRequestDto;
import org.example.domain.gold.dto.response.GetGoldPricesResponseDto;
import org.example.domain.gold.usecase.BuyGoldUseCase;
import org.example.domain.gold.usecase.GetGoldPriceDataUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gold")
@RequiredArgsConstructor
public class GoldWebAdapter {
    private final GetGoldPriceDataUseCase getGoldPriceDataUseCase;
    private final BuyGoldUseCase buyGoldUseCase;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/price")
    public GetGoldPricesResponseDto getGoldPriceData() {
        return getGoldPriceDataUseCase.execute();
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/buy")
    public void buyGoldData(@Validated @RequestBody BuyGoldRequestDto request) {
        buyGoldUseCase.execute(request);
    }
}
