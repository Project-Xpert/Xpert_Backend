package org.example.domain.fx.dto.request;

import jakarta.validation.constraints.Min;
import org.example.common.annotation.ValidEnum;
import org.example.domain.fx.model.FxType;

public record SellFxRequestDto(

    @ValidEnum(enumClass = FxType.class)
    FxType type,

    @Min(1)
    int amount
) {
}
