package org.example.global.thirdparty.openAPI.stock;

import lombok.RequiredArgsConstructor;
import org.example.common.openAPI.stock.StockOpenApiService;
import org.example.common.openAPI.stock.vo.GetAnalystOpinionResultVO;
import org.example.common.openAPI.stock.vo.GetCompanyProfileVO;
import org.example.common.openAPI.stock.vo.GetStockPriceResultVO;
import org.example.global.thirdparty.openAPI.stock.services.GetAnalystOpinionService;
import org.example.global.thirdparty.openAPI.stock.services.GetCompanyProfileService;
import org.example.global.thirdparty.openAPI.stock.services.GetStockPriceService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockOpenApiAdapter implements StockOpenApiService {
    private final GetStockPriceService getStockPriceService;
    private final GetAnalystOpinionService getAnalystOpinionService;
    private final GetCompanyProfileService getCompanyProfileService;


    public GetStockPriceResultVO getStockPrice(String stockCode) {
        return getStockPriceService.execute(stockCode);
    }

    @Override
    public GetAnalystOpinionResultVO getAnalystOpinions(String stockCode) {
        return getAnalystOpinionService.execute(stockCode);
    }

    @Override
    public GetCompanyProfileVO getCompanyProfile(String stockCode) {
        return getCompanyProfileService.execute(stockCode);
    }
}
