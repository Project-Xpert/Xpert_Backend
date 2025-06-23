package org.example.domain.stock.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.stock.modal.StockHolding;
import org.example.domain.stock.service.CommandStockHoldingService;
import org.example.domain.stock.spi.QueryStockHoldingPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandStockHoldingServiceImpl implements CommandStockHoldingService {
    private final QueryStockHoldingPort queryStockHoldingPort;

    public void save(StockHolding stockHolding) {
        queryStockHoldingPort.save(stockHolding);
    }
}
