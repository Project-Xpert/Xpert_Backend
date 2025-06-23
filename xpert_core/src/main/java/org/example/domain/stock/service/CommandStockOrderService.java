package org.example.domain.stock.service;

import org.example.domain.stock.modal.StockOrder;

public interface CommandStockOrderService {
    void save(StockOrder stockOrder);
}
