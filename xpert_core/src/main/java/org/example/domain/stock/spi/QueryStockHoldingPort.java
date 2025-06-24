package org.example.domain.stock.spi;

import org.example.domain.stock.modal.StockHolding;

import java.util.Optional;

public interface QueryStockHoldingPort {

    boolean existsByUserIdAndStockCode(String userId, String stockCode);

    void save(StockHolding stockHolding);

    Optional<StockHolding> getStockHoldingByUserIdAndStockCode(String userId, String stockCode);

    void delete(StockHolding stockHolding);
}
