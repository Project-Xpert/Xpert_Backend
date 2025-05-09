package org.example.domain.fx.spi.vo;

import org.example.domain.fx.model.FxType;

import java.math.BigDecimal;

public record FxDataWithRangeVO(
    FxType fxType,
    int price,
    int buyPrice,
    int sellPrice,
    BigDecimal fluRate
) {
    
    public static FxDataWithRangeVO from(Object[] object) {
        return new FxDataWithRangeVO(
                FxType.valueOf((String) object[0]),
                (int) object[1],
                (int) object[2],
                (int) object[3],
                (BigDecimal) object[4]
        );
    }
}
