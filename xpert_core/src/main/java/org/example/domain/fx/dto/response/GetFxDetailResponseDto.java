package org.example.domain.fx.dto.response;

import org.example.domain.fx.spi.vo.FxDetailVO;

public record GetFxDetailResponseDto(
    int sellPrice,
    int buyPrice,
    int price,
    int amount,
    int sumOfBuy
) {
    public static GetFxDetailResponseDto from(FxDetailVO fxDetailVO) {
        return new GetFxDetailResponseDto(
                fxDetailVO.sellPrice(),
                fxDetailVO.buyPrice(),
                fxDetailVO.price(),
                fxDetailVO.amount(),
                fxDetailVO.sumOfBuy()
        );
    }
}
