package org.example.stock.mapper;

import lombok.RequiredArgsConstructor;
import org.example.GenericMapper;
import org.example.domain.stock.modal.StockHolding;
import org.example.stock.entity.StockHoldingJpaEntity;
import org.example.stock.entity.StockJpaEntity;
import org.example.stock.repository.StockJpaRepository;
import org.example.user.entity.UserJpaEntity;
import org.example.user.repository.UserJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StockHoldingMapper implements GenericMapper<StockHolding, StockHoldingJpaEntity> {
    private final StockJpaRepository stockJpaRepository;
    private final UserJpaRepository userJpaRepository;

    @Override
    public Optional<StockHolding> toDomain(Optional<StockHoldingJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        StockHoldingJpaEntity stockHoldingEntity = entity.get();

        return Optional.of(StockHolding.builder()
                .stockCode(stockHoldingEntity.getStock().getStockCode())
                .userId(stockHoldingEntity.getUser().getUserId())
                .amount(stockHoldingEntity.getAmount())
                .sumOfBuy(stockHoldingEntity.getSumOfBuy())
                .build()
        );
    }

    @Override
    public StockHoldingJpaEntity toEntity(StockHolding domain) {
        StockJpaEntity stockEntity = stockJpaRepository.findById(domain.getStockCode()).get();
        UserJpaEntity userEntity = userJpaRepository.findById(domain.getUserId()).get();

        return new StockHoldingJpaEntity(
                stockEntity,
                userEntity,
                domain.getAmount(),
                domain.getSumOfBuy()
        );
    }
}
