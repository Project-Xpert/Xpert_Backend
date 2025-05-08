package org.example.fx.repository;

import org.example.domain.fx.spi.vo.FxDataWithRangeVO;
import org.example.fx.entity.FxDataId;
import org.example.fx.entity.FxDataJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FxDataJpaRepository extends CrudRepository<FxDataJpaEntity, FxDataId> {

    @Query(value = """
        SELECT 
            t.type,
            t.price,
            t.buy_price,
            t.sell_price,
            ROUND((CAST(t.price AS SIGNED) - CAST(y.price AS SIGNED)) / y.price * 100, 2) AS rate
        FROM 
            (SELECT * FROM fx_data ORDER BY date DESC LIMIT 6) t
        JOIN 
            (SELECT * FROM fx_data ORDER BY date DESC LIMIT 6 OFFSET 6) y
            ON t.type = y.type
    """, nativeQuery = true)
    List<Object[]> getNewestFxData();
}
