package org.example.domain.stock.spi;

import org.example.domain.stock.modal.Stock;
import org.example.domain.stock.modal.StockPrice;

import java.util.Optional;

public interface QueryStockPricePort {

    void save(StockPrice stockPrice);

    Optional<StockPrice> getStockPriceByStockCode(String stockCode);
}
