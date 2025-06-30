package org.example.stock.repository;

import org.example.domain.stock.spi.vo.CategoryListItemVO;
import org.example.domain.stock.spi.vo.StockListItemVO;
import org.example.stock.entity.StockJpaEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StockJpaRepository extends CrudRepository<StockJpaEntity, String> {

    @Query("""
        SELECT s
        FROM stock s
    """)
    List<StockJpaEntity> findAllStocks();

    @Query("""
        SELECT NEW org.example.domain.stock.spi.vo.StockListItemVO(
            s.stockCode,
            s.stockName,
            sp.price,
            sp.percentChange,
            false
        )
        FROM stock s INNER JOIN stock_price sp ON s = sp.stock
        WHERE s.stockName LIKE CONCAT('%', :keyword, '%')
           OR s.stockCode LIKE CONCAT('%', :keyword, '%')
        ORDER BY sp.date DESC
    """)
    List<StockListItemVO> searchStocksByKeywordAndOrder(@Param("keyword") String keyword, Pageable pageable);

    @Query("""
        SELECT NEW org.example.domain.stock.spi.vo.StockListItemVO(
            s.stockCode,
            s.stockName,
            sp.price,
            sp.percentChange,
            false
        )
        FROM stock s INNER JOIN stock_price sp ON s = sp.stock
        WHERE s.stockName LIKE CONCAT('%', :keyword, '%')
           OR s.stockCode LIKE CONCAT('%', :keyword, '%')
        ORDER BY sp.date DESC, abs(sp.percentChange) DESC
        LIMIT 60
    """)
    List<StockListItemVO> searchStocksByKeywordAndOrderByAbsChangePercent(@Param("keyword") String keyword);

    @Query("""
        SELECT new org.example.domain.stock.spi.vo.CategoryListItemVO(
            s.category,
            ROUND(SUM(sp.price), 0),
            ROUND(AVG(sp.percentChange), 2),
            COUNT(s),
            SUM(CASE WHEN sp.percentChange > 0 THEN 1 ELSE 0 END)
        )
        FROM stock s INNER JOIN stock_price sp ON s = sp.stock
        GROUP BY s.category
    """)
    List<CategoryListItemVO> getCategoryStockData();
}
