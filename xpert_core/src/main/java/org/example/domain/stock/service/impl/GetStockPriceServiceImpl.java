package org.example.domain.stock.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.stock.exception.StockPriceNotFoundException;
import org.example.domain.stock.modal.StockPrice;
import org.example.domain.stock.service.GetStockPriceService;
import org.example.domain.stock.spi.QueryStockPricePort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetStockPriceServiceImpl implements GetStockPriceService {
    private final QueryStockPricePort queryStockPricePort;

    @Override
    public StockPrice getStockPriceByStockCode(String stockCode) {
        return queryStockPricePort.getStockPriceByStockCode(stockCode)
                .orElseThrow(() -> StockPriceNotFoundException.EXCEPTION);
    }
}
