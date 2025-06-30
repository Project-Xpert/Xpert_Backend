package org.example.domain.stock.service;

import org.example.domain.stock.dto.vo.StockOrderByEnum;
import org.example.domain.stock.modal.StockHolding;
import org.example.domain.stock.spi.vo.StockListItemVO;

import java.util.List;

public interface GetStockHoldingService {

    StockHolding getStockHoldingByUserIdAndStockCode(String userId, String stockCode);

    List<StockListItemVO> getOwnedStockListByUserId(String userId, String keyword, StockOrderByEnum criteria);
}
