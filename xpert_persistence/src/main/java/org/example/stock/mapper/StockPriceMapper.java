package org.example.stock.mapper;

import lombok.RequiredArgsConstructor;
import org.example.GenericMapper;
import org.example.domain.stock.modal.Stock;
import org.example.domain.stock.modal.StockPrice;
import org.example.stock.entity.StockJpaEntity;
import org.example.stock.entity.StockPriceJpaEntity;
import org.example.stock.repository.StockJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StockPriceMapper implements GenericMapper<StockPrice, StockPriceJpaEntity> {
    private final StockJpaRepository stockJpaRepository;
    private final StockMapper stockMapper;

    @Override
    public Optional<StockPrice> toDomain(Optional<StockPriceJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        StockPriceJpaEntity stockPriceEntity = entity.get();
        Stock stock = stockMapper.toDomain(Optional.of(stockPriceEntity.getStock())).get();

        return Optional.of(StockPrice.builder()
                .stock(stock)
                .date(stockPriceEntity.getDate())
                .price(stockPriceEntity.getPrice())
                .build()
        );
    }

    @Override
    public StockPriceJpaEntity toEntity(StockPrice domain) {
        StockJpaEntity stockEntity = stockJpaRepository.findById(domain.getStock().getStockCode()).get();

        return new StockPriceJpaEntity(
                stockEntity,
                domain.getDate(),
                domain.getPrice()
        );
    }
}
