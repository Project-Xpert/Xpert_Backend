package org.example.domain.stock.usecase;

import lombok.RequiredArgsConstructor;
import org.example.domain.fx.service.GetFxDataService;
import org.example.domain.stock.dto.response.SearchStockListResponseDto;
import org.example.domain.stock.dto.vo.StockOrderByEnum;
import org.example.domain.stock.service.GetStockService;
import org.example.domain.stock.spi.vo.StockListItemVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SearchStockListUseCase {
    private final GetStockService getStockService;
    private final GetFxDataService getFxDataService;

    public SearchStockListResponseDto execute(String keyword, StockOrderByEnum criteria) {
        int dollarPrice = getFxDataService.getTodayDollarPrice();

        List<StockListItemVO> stockList = getStockService.searchStockByKeywordAndOrder(keyword, criteria)
                .stream()
                .map(data -> new StockListItemVO(
                        data.stockId(),
                        data.stockName(),
                        Math.round(data.price() * dollarPrice),
                        data.fluRate(),
                        data.isBookmarked()
                ))
                .toList();

        return new SearchStockListResponseDto(stockList);
    }
}
