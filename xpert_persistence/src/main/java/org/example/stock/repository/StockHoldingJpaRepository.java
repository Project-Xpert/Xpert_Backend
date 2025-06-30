package org.example.stock.repository;

import org.example.domain.stock.spi.vo.StockListItemVO;
import org.example.stock.entity.StockHoldingId;
import org.example.stock.entity.StockHoldingJpaEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StockHoldingJpaRepository extends CrudRepository<StockHoldingJpaEntity, StockHoldingId> {

    @Query("""
        SELECT new org.example.domain.stock.spi.vo.StockListItemVO(
            s.stockCode,
            s.stockName,
            sp.price,
            sp.percentChange,
            false
        )
        FROM stock s INNER JOIN stock_holding sh ON (s = sh.stock)
                     INNER JOIN stock_price sp ON (s = sp.stock)
        WHERE sh.user.userId = :userId
          AND sp.date = (current_date)
          AND (s.stockName LIKE CONCAT('%', :keyword, '%')
           OR s.stockCode LIKE CONCAT('%', :keyword, '%'))
    """)
    List<StockListItemVO> getOwnedStockListByUserId(
            @Param("userId") String userId,
            @Param("keyword") String keyword,
            Pageable pageable
    );

    @Query("""
        SELECT new org.example.domain.stock.spi.vo.StockListItemVO(
            s.stockCode,
            s.stockName,
            sp.price,
            sp.percentChange,
            false
        )
        FROM stock s INNER JOIN stock_holding sh ON (s = sh.stock)
                     INNER JOIN stock_price sp ON (s = sp.stock)
        WHERE sh.user.userId = :userId
          AND sp.date = (current_date)
          AND (s.stockName LIKE CONCAT('%', :keyword, '%')
           OR s.stockCode LIKE CONCAT('%', :keyword, '%'))
        ORDER BY abs(sp.percentChange) DESC
    """)
    List<StockListItemVO> getOwnedStockListByUserIdOrderByFluRateAbs(
            @Param("userId") String userId,
            @Param("keyword") String keyword
    );
}
