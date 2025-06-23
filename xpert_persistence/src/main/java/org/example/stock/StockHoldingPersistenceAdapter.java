package org.example.stock;

import lombok.RequiredArgsConstructor;
import org.example.domain.stock.modal.StockHolding;
import org.example.domain.stock.spi.QueryStockHoldingPort;
import org.example.stock.entity.StockHoldingId;
import org.example.stock.entity.StockJpaEntity;
import org.example.stock.mapper.StockHoldingMapper;
import org.example.stock.repository.StockHoldingJpaRepository;
import org.example.stock.repository.StockJpaRepository;
import org.example.user.entity.UserJpaEntity;
import org.example.user.repository.UserJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StockHoldingPersistenceAdapter implements QueryStockHoldingPort {
    private final StockHoldingJpaRepository stockHoldingJpaRepository;
    private final UserJpaRepository userJpaRepository;
    private final StockJpaRepository stockJpaRepository;
    private final StockHoldingMapper stockHoldingMapper;

    @Override
    public boolean existsByUserIdAndStockCode(String userId, String stockCode) {
        UserJpaEntity userEntity = userJpaRepository.findById(userId).get();
        StockJpaEntity stockEntity = stockJpaRepository.findById(stockCode).get();

        return stockHoldingJpaRepository.existsById(new StockHoldingId(userEntity, stockEntity));
    }

    @Override
    public void save(StockHolding stockHolding) {
        System.out.println(stockHolding.getStockCode());
        stockHoldingJpaRepository.save(
                stockHoldingMapper.toEntity(stockHolding)
        );
    }

    @Override
    public Optional<StockHolding> getStockHoldingByUserIdAndStockCode(String userId, String stockCode) {
        UserJpaEntity userEntity = userJpaRepository.findById(userId).get();
        StockJpaEntity stockEntity = stockJpaRepository.findById(stockCode).get();

        return stockHoldingMapper.toDomain(
                stockHoldingJpaRepository.findById(
                        new StockHoldingId(userEntity, stockEntity)
                )
        );
    }
}
