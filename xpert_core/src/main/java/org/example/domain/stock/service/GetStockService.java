package org.example.domain.stock.service;

import org.example.domain.stock.modal.Stock;
import org.example.domain.stock.spi.vo.StockCodeListVO;

import java.util.List;

public interface GetStockService {

    List<Stock> getStocks();
}
