package org.example.domain.stock.spi;

import org.example.domain.stock.modal.StockPrice;

public interface QueryStockPricePort {

    void save(StockPrice stockPrice);
}
