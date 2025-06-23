package org.example.domain.stock.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.stock.modal.Stock;
import org.example.domain.stock.modal.StockHolding;
import org.example.domain.stock.service.CheckStockHoldingService;
import org.example.domain.stock.service.CommandStockHoldingService;
import org.example.domain.stock.service.GetStockHoldingService;
import org.example.domain.stock.spi.QueryStockHoldingPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandStockHoldingServiceImpl implements CommandStockHoldingService {
    private final QueryStockHoldingPort queryStockHoldingPort;
    private final CheckStockHoldingService checkStockHoldingService;
    private final GetStockHoldingService getStockHoldingService;

    @Override
    public void buyStock(StockHolding newStock) {

        // 기존 데이터가 존재하지 않는다면 바로 저장하고 리턴
        if (!checkStockHoldingService.getExistsByUserIdAndStockCode(
                newStock.getUserId(), newStock.getStockCode())) {
            queryStockHoldingPort.save(newStock);
            return;
        }

        StockHolding prevStockHolding = getStockHoldingService
                .getStockHoldingByUserIdAndStockCode(newStock.getUserId(), newStock.getStockCode());

        StockHolding mergedHolding = newStock.marge(prevStockHolding);

        queryStockHoldingPort.save(mergedHolding);
    }
}
