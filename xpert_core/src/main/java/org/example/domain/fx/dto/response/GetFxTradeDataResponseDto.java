package org.example.domain.fx.dto.response;

import org.example.domain.fx.spi.vo.FxTradeDataVO;
import org.example.domain.user.model.User;

public record GetFxTradeDataResponseDto(
    int sellPrice,
    int buyPrice,
    Long userMoney
) {
    public static GetFxTradeDataResponseDto of(User user, FxTradeDataVO fxTradeData) {
        return new GetFxTradeDataResponseDto(
                fxTradeData.sellPrice(),
                fxTradeData.buyPrice(),
                user.getMoney()
        );
    }
}
