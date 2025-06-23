package org.example.domain.stock.service;

import org.example.domain.stock.modal.StockHolding;

public interface GetStockHoldingService {

    StockHolding getStockHoldingByUserIdAndStockCode(String userId, String stockCode);
}
