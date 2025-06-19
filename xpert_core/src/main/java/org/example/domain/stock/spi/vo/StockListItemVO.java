package org.example.domain.stock.spi.vo;

public record StockListItemVO(
    String stockId,
    String stockName,
    double price,
    double fluRate,
    boolean isBookmarked
) {
}
