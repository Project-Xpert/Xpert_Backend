package org.example.domain.gold.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.example.common.annotation.ValidEnum;
import org.example.domain.gold.model.GoldType;

public record BuyGoldRequestDto(
        @ValidEnum(enumClass = GoldType.class) GoldType goldType,
        @NotNull @Min(1) Integer cnt,
        @NotNull @Min(1) Integer price
) {
}
