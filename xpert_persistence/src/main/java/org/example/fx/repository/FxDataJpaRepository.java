package org.example.fx.repository;

import org.example.domain.fx.model.FxType;
import org.example.domain.fx.spi.vo.FxDetailVO;
import org.example.fx.entity.FxDataId;
import org.example.fx.entity.FxDataJpaEntity;
import org.example.user.entity.UserJpaEntity;
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


    @Query("""
        SELECT
            new org.example.domain.fx.spi.vo.FxDetailVO(
                fd.sellPrice,
                fd.buyPrice,
                fd.price,
                COALESCE(f.amount, 0) ,
                COALESCE(f.sumOfBuy, 0)
            )
        FROM fx_data fd LEFT OUTER JOIN fx f ON fd.type = f.type
        WHERE fd.type = :fxType
            AND (f.user = :user OR f.user IS NULL)
        ORDER BY fd.date DESC
        LIMIT 1
    """)
    FxDetailVO getFxDetail(UserJpaEntity user, FxType fxType);
}
