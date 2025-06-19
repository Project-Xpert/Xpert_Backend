package org.example.common.openAPI.stock;

import org.example.common.openAPI.stock.vo.GetStockPriceResultVO;

public interface StockOpenApiService {

    GetStockPriceResultVO getStockPrice(String stockCode);
}
