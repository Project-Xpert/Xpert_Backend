package org.example.stock.repository;

import org.example.stock.entity.StockPriceId;
import org.example.stock.entity.StockPriceJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface StockPriceJpaRepository extends CrudRepository<StockPriceJpaEntity, StockPriceId> {
}
