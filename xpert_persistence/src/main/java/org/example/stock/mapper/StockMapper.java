package org.example.stock.mapper;

import org.example.GenericMapper;
import org.example.domain.stock.modal.Stock;
import org.example.stock.entity.StockJpaEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StockMapper implements GenericMapper<Stock, StockJpaEntity> {
    @Override
    public Optional<Stock> toDomain(Optional<StockJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        StockJpaEntity stockEntity = entity.get();

        return Optional.of(Stock.builder()
                .stockCode(stockEntity.getStockCode())
                .stockName(stockEntity.getStockName())
                .category(stockEntity.getCategory())
                .tossStockCode(stockEntity.getTossStockCode())
                .build()
        );
    }

    @Override
    public StockJpaEntity toEntity(Stock domain) {
        return new StockJpaEntity(
                domain.getStockCode(),
                domain.getStockName(),
                domain.getCategory(),
                domain.getTossStockCode()
        );
    }
}
