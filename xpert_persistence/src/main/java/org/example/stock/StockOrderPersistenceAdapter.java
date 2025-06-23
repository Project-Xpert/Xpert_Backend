package org.example.stock;

import lombok.RequiredArgsConstructor;
import org.example.domain.stock.modal.StockOrder;
import org.example.domain.stock.spi.QueryStockOrderPort;
import org.example.stock.mapper.StockOrderMapper;
import org.example.stock.repository.StockOrderJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockOrderPersistenceAdapter implements QueryStockOrderPort {
    private final StockOrderJpaRepository stockOrderJpaRepository;
    private final StockOrderMapper stockOrderMapper;

    @Override
    public void save(StockOrder stockOrder) {
        stockOrderJpaRepository.save(stockOrderMapper.toEntity(stockOrder));
    }
}
