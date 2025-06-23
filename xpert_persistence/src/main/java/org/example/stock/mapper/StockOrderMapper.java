package org.example.stock.mapper;

import lombok.RequiredArgsConstructor;
import org.example.GenericMapper;
import org.example.domain.stock.modal.StockOrder;
import org.example.stock.entity.StockJpaEntity;
import org.example.stock.entity.StockOrderJpaEntity;
import org.example.stock.repository.StockJpaRepository;
import org.example.user.entity.UserJpaEntity;
import org.example.user.repository.UserJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StockOrderMapper implements GenericMapper<StockOrder, StockOrderJpaEntity> {
    private final UserJpaRepository userJpaRepository;
    private final StockJpaRepository stockJpaRepository;

    @Override
    public Optional<StockOrder> toDomain(Optional<StockOrderJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        StockOrderJpaEntity stockOrderEntity = entity.get();

        return Optional.of(StockOrder.builder()
                .orderId(stockOrderEntity.getOrderId())
                .stockCode(stockOrderEntity.getStock().getStockCode())
                .userId(stockOrderEntity.getUser().getUserId())
                .price(stockOrderEntity.getPrice())
                .amount(stockOrderEntity.getAmount())
                .tradeType(stockOrderEntity.getTradeType())
                .build());
    }

    @Override
    public StockOrderJpaEntity toEntity(StockOrder domain) {
        UserJpaEntity userEntity = userJpaRepository.findById(domain.getUserId()).get();
        StockJpaEntity stockEntity = stockJpaRepository.findById(domain.getStockCode()).get();

        return new StockOrderJpaEntity(
                domain.getOrderId(),
                stockEntity,
                userEntity,
                domain.getPrice(),
                domain.getAmount(),
                domain.getTradeType()
        );
    }
}
