package org.example.domain.stock.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.stock.dto.vo.StockOrderByEnum;
import org.example.domain.stock.exception.StockNotFoundException;
import org.example.domain.stock.modal.Stock;
import org.example.domain.stock.service.GetStockService;
import org.example.domain.stock.spi.QueryStockPort;
import org.example.domain.stock.spi.vo.StockListItemVO;
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

    @Override
    public List<StockListItemVO> searchStockByKeywordAndOrder(String keyword, StockOrderByEnum criteria) {
        return queryStockPort.searchStockByKeywordAndOrder(keyword, criteria);
    }

    @Override
    public Stock getStockByStockCode(String stockCode) {
        return queryStockPort.getStockById(stockCode)
                .orElseThrow(() -> StockNotFoundException.EXCEPTION);
    }
}
