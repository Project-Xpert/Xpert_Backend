package org.example.domain.stock.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.stock.dto.vo.StockOrderByEnum;
import org.example.domain.stock.exception.StockHoldingNotFoundException;
import org.example.domain.stock.modal.StockHolding;
import org.example.domain.stock.service.GetStockHoldingService;
import org.example.domain.stock.spi.QueryStockHoldingPort;
import org.example.domain.stock.spi.vo.StockListItemVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetStockHoldingServiceImpl implements GetStockHoldingService {
    private final QueryStockHoldingPort queryStockHoldingPort;

    @Override
    public StockHolding getStockHoldingByUserIdAndStockCode(String userId, String stockCode) {
        return queryStockHoldingPort.getStockHoldingByUserIdAndStockCode(userId, stockCode)
                .orElseThrow(() -> StockHoldingNotFoundException.EXCEPTION);
    }

    @Override
    public List<StockListItemVO> getOwnedStockListByUserId(String userId, String keyword, StockOrderByEnum criteria) {
        return queryStockHoldingPort.getOwnedStockListByUserId(userId, keyword, criteria);
    }
}
