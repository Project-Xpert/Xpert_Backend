package org.example.domain.stock.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.openAPI.stock.StockOpenApiService;
import org.example.common.openAPI.stock.vo.GetStockPriceResultVO;
import org.example.domain.stock.modal.Stock;
import org.example.domain.stock.modal.StockPrice;
import org.example.domain.stock.service.CommandStockPriceService;
import org.example.domain.stock.service.GetStockService;
import org.example.domain.stock.spi.vo.StockCodeListVO;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleStockPriceUseCase {
    private final StockOpenApiService stockOpenApiService;
    private final GetStockService getStockService;
    private final CommandStockPriceService commandStockPriceService;

    @Scheduled(cron = "0 0/1 * 1/1 * ?")
    public void execute() {
        List<Stock> stockList = getStockService.getStocks();

        for (Stock stock: stockList) {
            GetStockPriceResultVO stockPrice = stockOpenApiService.getStockPrice(stock.getStockCode());

            commandStockPriceService.save(StockPrice.builder()
                    .stock(stock)
                    .date(LocalDate.now())
                    .price(stockPrice.currentPrice())
                    .priceChange(stockPrice.priceChange())
                    .percentChange(stockPrice.percentChange())
                    .build());
        }
    }
}
