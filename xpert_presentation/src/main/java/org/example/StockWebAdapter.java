package org.example;

import lombok.RequiredArgsConstructor;
import org.example.domain.stock.dto.response.GetStockDetailResponseDto;
import org.example.domain.stock.dto.response.SearchStockListResponseDto;
import org.example.domain.stock.dto.vo.StockOrderByEnum;
import org.example.domain.stock.usecase.GetStockDetailUseCase;
import org.example.domain.stock.usecase.SearchStockListUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockWebAdapter {
    private final SearchStockListUseCase searchStockListUseCase;
    private final GetStockDetailUseCase getStockDetailUseCase;

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
}
