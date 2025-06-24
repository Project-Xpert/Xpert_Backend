package org.example;

import lombok.RequiredArgsConstructor;
import org.example.domain.stock.dto.request.BuyStockRequestDto;
import org.example.domain.stock.dto.request.SellStockRequestDto;
import org.example.domain.stock.dto.response.GetStockDetailResponseDto;
import org.example.domain.stock.dto.response.GetStockHoldingResponseDto;
import org.example.domain.stock.dto.response.SearchStockListResponseDto;
import org.example.domain.stock.dto.vo.StockOrderByEnum;
import org.example.domain.stock.usecase.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockWebAdapter {
    private final SearchStockListUseCase searchStockListUseCase;
    private final GetStockDetailUseCase getStockDetailUseCase;
    private final BuyStockUseCase buyStockUseCase;
    private final SellStockUseCase sellStockUseCase;
    private final GetStockHoldingUseCase getStockHoldingUseCase;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/search")
    public SearchStockListResponseDto searchStockList(
        @RequestParam("keyword") String keyword,
        @RequestParam("sort") StockOrderByEnum criteria
    ) {
        return searchStockListUseCase.execute(keyword, criteria);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/detail/{stockCode}")
    public GetStockDetailResponseDto getStockDetail(@PathVariable String stockCode) {
        return getStockDetailUseCase.execute(stockCode);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/buy")
    public void buyStock(@RequestBody BuyStockRequestDto request) {
        buyStockUseCase.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/sell")
    public void sellStock(@RequestBody SellStockRequestDto request) {
        sellStockUseCase.execute(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/holding/{stockCode}")
    public GetStockHoldingResponseDto getStockHolding(@PathVariable String stockCode) {
        return getStockHoldingUseCase.execute(stockCode);
    }
}
