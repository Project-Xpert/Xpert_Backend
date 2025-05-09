package org.example.domain.fx.dto.response;


import org.example.domain.fx.model.FxData;
import org.example.domain.fx.spi.vo.OwnFxVO;

public record GetFxDetailResponseDto(
    int price,
    int amount,
    int sumOfBuy
) {
    public static GetFxDetailResponseDto of(OwnFxVO ownFxVO, FxData fxData) {
        return new GetFxDetailResponseDto(
                fxData.getPrice(),
                ownFxVO.amount(),
                ownFxVO.sumOfBuy()
        );
    }
}
