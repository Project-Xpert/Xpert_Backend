package org.example.domain.stock.dto.response;

import org.example.common.openAPI.stock.vo.GetAnalystOpinionResultVO;
import org.example.common.openAPI.stock.vo.GetCompanyProfileVO;
import org.example.domain.stock.modal.Stock;
import org.example.domain.stock.modal.StockPrice;

public record GetStockDetailResponseDto(
    String stockName,
    long priceKR,
    long priceUS,
    boolean isBookmarked,
    long fluAmount,
    double fluRate,
    GetCompanyProfileVO companyDetail,
    int[] analystOpinion
) {
    public static GetStockDetailResponseDto of(
            Stock stock,
            StockPrice stockPrice,
            GetCompanyProfileVO companyDetail,
            GetAnalystOpinionResultVO analystOpinion,
            int dollarPrice
    ) {
        return new GetStockDetailResponseDto(
                stock.getStockName(),
                Math.round(stockPrice.getPrice() * dollarPrice),
                Math.round(stockPrice.getPrice()),
                false,
                Math.round(stockPrice.getPriceChange() * dollarPrice),
                stockPrice.getPercentChange(),
                companyDetail,
                analystOpinion.opinions()
        );
    }
}
