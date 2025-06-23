package org.example.stock.repository;

import org.example.stock.entity.StockHoldingId;
import org.example.stock.entity.StockHoldingJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface StockHoldingJpaRepository extends CrudRepository<StockHoldingJpaEntity, StockHoldingId> {
}
