package org.example.domain.stock.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.fx.service.GetFxDataService;
import org.example.domain.stock.dto.response.GetOwnStockListResponseDto;
import org.example.domain.stock.dto.vo.StockOrderByEnum;
import org.example.domain.stock.service.GetStockHoldingService;
import org.example.domain.stock.spi.vo.StockListItemVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetOwnStockListUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final GetStockHoldingService getStockHoldingService;
    private final GetFxDataService getFxDataService;

    public GetOwnStockListResponseDto execute(String keyword, StockOrderByEnum criteria) {
        String userId = currentUserProvider.getCurrentUserId();
        int todayDollarPrice = getFxDataService.getTodayDollarPrice();

        List<StockListItemVO> stockList = getStockHoldingService.getOwnedStockListByUserId(userId, keyword, criteria)
                .stream()
                .map(item -> new StockListItemVO(
                        item.stockId(),
                        item.stockName(),
                        item.price() * todayDollarPrice,
                        item.fluRate(),
                        item.isBookmarked())
                ).toList();

        return new GetOwnStockListResponseDto(stockList);
    }
}
