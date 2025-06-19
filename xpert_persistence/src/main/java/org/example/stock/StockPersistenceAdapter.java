package org.example.stock;

import lombok.RequiredArgsConstructor;
import org.example.domain.stock.spi.QueryStockPort;
import org.example.stock.mapper.StockMapper;
import org.example.stock.repository.StockJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockPersistenceAdapter implements QueryStockPort {
    private final StockJpaRepository stockJpaRepository;
    private final StockMapper stockMapper;
}
