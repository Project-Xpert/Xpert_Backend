package org.example.domain.stock.spi;

import org.example.domain.stock.modal.Stock;

import java.util.List;

public interface QueryStockPort {

    List<Stock> getStocks();
}
