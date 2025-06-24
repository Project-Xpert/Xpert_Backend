package org.example.domain.stock.service;

import org.example.domain.stock.modal.StockHolding;

public interface CommandStockHoldingService {

    void buyStock(StockHolding stockHolding);

    void sellStock(StockHolding sellStock, int sellCnt);
}
