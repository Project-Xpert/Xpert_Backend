package org.example.common.openAPI.stock;

import org.example.common.openAPI.stock.vo.GetAnalystOpinionResultVO;
import org.example.common.openAPI.stock.vo.GetCompanyProfileVO;
import org.example.common.openAPI.stock.vo.GetStockPriceResultVO;

public interface StockOpenApiService {

    GetStockPriceResultVO getStockPrice(String stockCode);

    GetAnalystOpinionResultVO getAnalystOpinions(String stockCode);

    GetCompanyProfileVO getCompanyProfile(String stockCode);
}
