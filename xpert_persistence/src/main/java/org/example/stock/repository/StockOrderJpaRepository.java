package org.example.stock.repository;

import org.example.stock.entity.StockOrderJpaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface StockOrderJpaRepository extends CrudRepository<StockOrderJpaEntity, UUID> {
}
