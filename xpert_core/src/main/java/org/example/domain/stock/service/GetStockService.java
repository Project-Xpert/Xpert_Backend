package org.example.domain.stock.service;

import org.example.domain.stock.dto.vo.StockOrderByEnum;
import org.example.domain.stock.modal.Stock;
import org.example.domain.stock.spi.vo.StockListItemVO;

import java.util.List;

public interface GetStockService {

    List<Stock> getStocks();

    List<StockListItemVO> searchStockByKeywordAndOrder(String keyword, StockOrderByEnum criteria);
}
