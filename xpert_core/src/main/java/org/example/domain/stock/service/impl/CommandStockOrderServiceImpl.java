package org.example.domain.stock.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.stock.modal.StockOrder;
import org.example.domain.stock.service.CommandStockOrderService;
import org.example.domain.stock.spi.QueryStockOrderPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandStockOrderServiceImpl implements CommandStockOrderService {
    private final QueryStockOrderPort queryStockOrderPort;

    @Override
    public void save(StockOrder stockOrder) {
        queryStockOrderPort.save(stockOrder);
    }
}
