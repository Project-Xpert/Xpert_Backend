package org.example.stock.repository;

import org.example.stock.entity.StockJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface StockJpaRepository extends CrudRepository<StockJpaEntity, String> {
}
