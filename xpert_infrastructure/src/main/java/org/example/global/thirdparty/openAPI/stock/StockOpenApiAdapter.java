package org.example.global.thirdparty.openAPI.stock;

import lombok.RequiredArgsConstructor;
import org.example.common.openAPI.stock.StockOpenApiService;
import org.example.common.openAPI.stock.vo.GetStockPriceResultVO;
import org.example.global.thirdparty.openAPI.stock.services.GetStockPriceService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockOpenApiAdapter implements StockOpenApiService {
    private final GetStockPriceService getStockPriceService;

    public GetStockPriceResultVO getStockPrice(String stockCode) {
        return getStockPriceService.execute(stockCode);
    }
}
