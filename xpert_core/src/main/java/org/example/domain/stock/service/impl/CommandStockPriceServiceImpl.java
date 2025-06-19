package org.example.domain.stock.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.stock.modal.StockPrice;
import org.example.domain.stock.service.CommandStockPriceService;
import org.example.domain.stock.spi.QueryStockPricePort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandStockPriceServiceImpl implements CommandStockPriceService {
    private final QueryStockPricePort queryStockPricePort;

    @Override
    public void save(StockPrice stockPrice) {
        queryStockPricePort.save(stockPrice);
    }
}
