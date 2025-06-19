package org.example.domain.stock.service;

import org.example.domain.stock.modal.StockPrice;

public interface CommandStockPriceService {

    void save(StockPrice build);
}
