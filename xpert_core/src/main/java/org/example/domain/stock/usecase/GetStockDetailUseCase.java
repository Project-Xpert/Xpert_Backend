package org.example.domain.stock.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.openAPI.stock.StockOpenApiService;
import org.example.common.openAPI.stock.vo.GetAnalystOpinionResultVO;
import org.example.common.openAPI.stock.vo.GetCompanyProfileVO;
import org.example.domain.fx.service.GetFxDataService;
import org.example.domain.stock.dto.response.GetStockDetailResponseDto;
import org.example.domain.stock.modal.Stock;
import org.example.domain.stock.modal.StockPrice;
import org.example.domain.stock.service.GetStockPriceService;
import org.example.domain.stock.service.GetStockService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetStockDetailUseCase {
    private final StockOpenApiService stockOpenApiService;
    private final GetStockService getStockService;
    private final GetStockPriceService getStockPriceService;
    private final GetFxDataService getFxDataService;

    public GetStockDetailResponseDto execute(String stockCode) {
        GetAnalystOpinionResultVO analystOpinions = stockOpenApiService.getAnalystOpinions(stockCode);
        GetCompanyProfileVO companyProfile = stockOpenApiService.getCompanyProfile(stockCode);
        Stock stock = getStockService.getStockByStockCode(stockCode);
        StockPrice stockPrice = getStockPriceService.getStockPriceByStockCode(stockCode);
        int dollarPrice = getFxDataService.getTodayDollarPrice();

        return GetStockDetailResponseDto.of(stock, stockPrice, companyProfile, analystOpinions, dollarPrice);
    }
}
