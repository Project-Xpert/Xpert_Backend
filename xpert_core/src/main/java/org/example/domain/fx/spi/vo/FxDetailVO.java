package org.example.domain.fx.spi.vo;

public record FxDetailVO(
    int sellPrice,
    int buyPrice,
    int price,
    int amount,
    int sumOfBuy
) {
}
