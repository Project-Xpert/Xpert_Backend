package org.example.domain.fx.dto.response;

import org.example.domain.fx.model.FxData;
import org.example.domain.user.model.User;

public record GetFxTradeDataResponseDto(
    int sellPrice,
    int buyPrice,
    Long userMoney
) {
    public static GetFxTradeDataResponseDto of(User user, FxData fxData) {
        return new GetFxTradeDataResponseDto(
                fxData.getSellPrice(),
                fxData.getBuyPrice(),
                user.getMoney()
        );
    }
}
