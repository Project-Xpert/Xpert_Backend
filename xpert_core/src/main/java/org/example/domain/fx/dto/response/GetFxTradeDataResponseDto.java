package org.example.domain.fx.dto.response;

import org.example.domain.fx.model.Fx;
import org.example.domain.fx.model.FxData;
import org.example.domain.fx.spi.vo.OwnFxVO;
import org.example.domain.user.model.User;

public record GetFxTradeDataResponseDto(
    int sellPrice,
    int buyPrice,
    int ownedFx,
    Long userMoney
) {
    public static GetFxTradeDataResponseDto of(User user, OwnFxVO ownedFx, FxData fxData) {
        return new GetFxTradeDataResponseDto(
                fxData.getSellPrice(),
                fxData.getBuyPrice(),
                ownedFx.amount(),
                user.getMoney()
        );
    }
}
