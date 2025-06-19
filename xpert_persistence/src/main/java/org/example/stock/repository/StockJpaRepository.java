package org.example.stock.repository;

import org.example.stock.entity.StockJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StockJpaRepository extends CrudRepository<StockJpaEntity, String> {

    @Query("""
        SELECT s
        FROM stock s
    """)
    List<StockJpaEntity> findAllStocks();
}
