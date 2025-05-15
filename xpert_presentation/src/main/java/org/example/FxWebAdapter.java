package org.example;

import lombok.RequiredArgsConstructor;
import org.example.domain.fx.dto.request.BuyFxRequestDto;
import org.example.domain.fx.dto.request.SellFxRequestDto;
import org.example.domain.fx.dto.response.GetFxDetailResponseDto;
import org.example.domain.fx.dto.response.GetFxTradeDataResponseDto;
import org.example.domain.fx.dto.response.GetNewestFxDataResponseDto;
import org.example.domain.fx.model.FxType;
import org.example.domain.fx.usecase.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fx")
@RequiredArgsConstructor
public class FxWebAdapter {
    private final GetNewestFxDataUseCase getNewestFxDataUseCase;
    private final GetFxDetailUseCase getFxDetailUseCase;
    private final GetFxTradeDataUseCase getFxTradeDataUseCase;
    private final BuyFxUseCase buyFxUseCase;
    private final SellFxUseCase sellFxUseCase;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/price")
    public GetNewestFxDataResponseDto getNewestFxData() {
        return getNewestFxDataUseCase.execute();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/detail/{fxType}")
    public GetFxDetailResponseDto GetFxDetail(@PathVariable String fxType) {
        return getFxDetailUseCase.execute(FxType.valueOf(fxType));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/trade/{fxType}")
    public GetFxTradeDataResponseDto getFxTradeData(@PathVariable String fxType) {
        return getFxTradeDataUseCase.execute(FxType.valueOf(fxType));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void buyFx(@Validated @RequestBody BuyFxRequestDto request) {
        buyFxUseCase.execute(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping
    public void sellFx(@Validated @RequestBody SellFxRequestDto request) {
        sellFxUseCase.execute(request);
    }
}
