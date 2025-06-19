package org.example.stock;

import lombok.RequiredArgsConstructor;
import org.example.domain.stock.modal.StockPrice;
import org.example.domain.stock.spi.QueryStockPricePort;
import org.example.stock.mapper.StockPriceMapper;
import org.example.stock.repository.StockPriceJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockPricePersistenceAdapter implements QueryStockPricePort {
    private final StockPriceMapper stockPriceMapper;
    private final StockPriceJpaRepository stockPriceJpaRepository;

    @Override
    public void save(StockPrice stockPrice) {
        stockPriceJpaRepository.save(stockPriceMapper.toEntity(stockPrice));
    }
}
