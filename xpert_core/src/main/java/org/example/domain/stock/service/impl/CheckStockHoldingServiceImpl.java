package org.example.domain.stock.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.stock.service.CheckStockHoldingService;
import org.example.domain.stock.spi.QueryStockHoldingPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckStockHoldingServiceImpl implements CheckStockHoldingService {
    private final QueryStockHoldingPort queryStockHoldingPort;

    @Override
    public boolean getExistsByUserIdAndStockCode(String userId, String stockCode) {
        return queryStockHoldingPort.existsByUserIdAndStockCode(userId, stockCode);
    }
}
