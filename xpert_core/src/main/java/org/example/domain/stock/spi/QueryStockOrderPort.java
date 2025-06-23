package org.example.domain.stock.spi;

import org.example.domain.stock.modal.StockOrder;

public interface QueryStockOrderPort {
    void save(StockOrder stockOrder);
}
