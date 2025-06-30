package org.example.domain.stock.spi;

import org.example.domain.stock.dto.vo.StockOrderByEnum;
import org.example.domain.stock.modal.StockHolding;
import org.example.domain.stock.spi.vo.StockListItemVO;

import java.util.List;
import java.util.Optional;

public interface QueryStockHoldingPort {

    boolean existsByUserIdAndStockCode(String userId, String stockCode);

    void save(StockHolding stockHolding);

    Optional<StockHolding> getStockHoldingByUserIdAndStockCode(String userId, String stockCode);

    void delete(StockHolding stockHolding);

    List<StockListItemVO> getOwnedStockListByUserId(String userId, String keyword, StockOrderByEnum criteria);
}
