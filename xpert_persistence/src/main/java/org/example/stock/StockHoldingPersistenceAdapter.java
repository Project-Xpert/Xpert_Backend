package org.example.stock;

import lombok.RequiredArgsConstructor;
import org.example.domain.stock.modal.StockHolding;
import org.example.domain.stock.spi.QueryStockHoldingPort;
import org.example.stock.entity.StockHoldingId;
import org.example.stock.mapper.StockHoldingMapper;
import org.example.stock.repository.StockHoldingJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StockHoldingPersistenceAdapter implements QueryStockHoldingPort {
    private final StockHoldingJpaRepository stockHoldingJpaRepository;
    private final StockHoldingMapper stockHoldingMapper;

    @Override
    public boolean existsByUserIdAndStockCode(String userId, String stockCode) {
        return stockHoldingJpaRepository.existsById(new StockHoldingId(userId, stockCode));
    }

    @Override
    public void save(StockHolding stockHolding) {
        stockHoldingJpaRepository.save(
                stockHoldingMapper.toEntity(stockHolding)
        );
    }

    @Override
    public Optional<StockHolding> getStockHoldingByUserIdAndStockCode(String userId, String stockCode) {
        return stockHoldingMapper.toDomain(
                stockHoldingJpaRepository.findById(
                        new StockHoldingId(userId, stockCode)
                )
        );
    }
}
