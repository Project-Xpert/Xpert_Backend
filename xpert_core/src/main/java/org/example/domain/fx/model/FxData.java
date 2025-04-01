package org.example.domain.fx.model;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record FxData(
        LocalDate date,
        FXType type,
        int price,
        int buyPrice,
        int sellPrice
) {
}
