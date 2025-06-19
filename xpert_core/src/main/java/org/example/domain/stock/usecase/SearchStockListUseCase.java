package org.example.domain.stock.usecase;

import lombok.RequiredArgsConstructor;
import org.example.domain.stock.dto.response.SearchStockListResponseDto;
import org.example.domain.stock.dto.vo.StockOrderByEnum;
import org.example.domain.stock.service.GetStockService;
import org.example.domain.stock.spi.vo.StockListItemVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchStockListUseCase {
    private final GetStockService getStockService;

    public SearchStockListResponseDto execute(String keyword, StockOrderByEnum criteria) {
        List<StockListItemVO> stockList = getStockService.searchStockByKeywordAndOrder(keyword, criteria);

        return new SearchStockListResponseDto(stockList);
    }
}
