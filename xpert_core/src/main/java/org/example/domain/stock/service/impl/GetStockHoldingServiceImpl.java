package org.example.domain.stock.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.stock.exception.StockHoldingNotFoundException;
import org.example.domain.stock.modal.StockHolding;
import org.example.domain.stock.service.GetStockHoldingService;
import org.example.domain.stock.spi.QueryStockHoldingPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetStockHoldingServiceImpl implements GetStockHoldingService {
    private final QueryStockHoldingPort queryStockHoldingPort;

    @Override
    public StockHolding getStockHoldingByUserIdAndStockCode(String userId, String stockCode) {
        return queryStockHoldingPort.getStockHoldingByUserIdAndStockCode(userId, stockCode)
                .orElseThrow(() -> StockHoldingNotFoundException.EXCEPTION);
    }
}
