package org.example.domain.stock.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.stock.modal.Stock;
import org.example.domain.stock.service.GetStockService;
import org.example.domain.stock.spi.QueryStockPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetStockServiceImpl implements GetStockService {
    private final QueryStockPort queryStockPort;

    @Override
    public List<Stock> getStocks() {
        return queryStockPort.getStocks();
    }
}
