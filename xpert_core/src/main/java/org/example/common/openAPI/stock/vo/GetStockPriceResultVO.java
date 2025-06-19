package org.example.common.openAPI.stock.vo;

public record GetStockPriceResultVO (
    double currentPrice,
    double priceChange,
    double percentChange
) {}
