package org.example;

import lombok.RequiredArgsConstructor;
import org.example.domain.fx.dto.request.BuyFxRequestDto;
import org.example.domain.fx.dto.response.GetFxDetailResponseDto;
import org.example.domain.fx.dto.response.GetFxTradeDataResponseDto;
import org.example.domain.fx.dto.response.GetNewestFxDataResponseDto;
import org.example.domain.fx.model.FxType;
import org.example.domain.fx.usecase.BuyFxUseCase;
import org.example.domain.fx.usecase.GetFxDetailUseCase;
import org.example.domain.fx.usecase.GetFxTradeDataUseCase;
import org.example.domain.fx.usecase.GetNewestFxDataUseCase;
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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/price")
    public GetNewestFxDataResponseDto getNewestFxData() {
        return getNewestFxDataUseCase.execute();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/detail/{fxType}")
    private GetFxDetailResponseDto GetFxDetail(@PathVariable String fxType) {
        return getFxDetailUseCase.execute(FxType.valueOf(fxType));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/trade/{fxType}")
    private GetFxTradeDataResponseDto getFxTradeData(@PathVariable String fxType) {
        return getFxTradeDataUseCase.execute(FxType.valueOf(fxType));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    private void buyFx(@Validated @RequestBody BuyFxRequestDto buyFxRequestDto) {
        buyFxUseCase.execute(buyFxRequestDto);
    }
}
