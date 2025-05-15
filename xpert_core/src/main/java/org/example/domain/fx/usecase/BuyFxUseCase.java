package org.example.domain.fx.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.fx.dto.request.BuyFxRequestDto;
import org.example.domain.fx.model.Fx;
import org.example.domain.fx.model.FxData;
import org.example.domain.fx.model.FxType;
import org.example.domain.fx.service.CommandFxService;
import org.example.domain.fx.service.GetFxDataService;
import org.example.domain.fx.service.GetFxService;
import org.example.domain.fx.spi.vo.OwnFxVO;
import org.example.domain.user.model.User;
import org.example.domain.user.service.CommandUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BuyFxUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final CommandUserService commandUserService;
    private final CommandFxService commandFxService;
    private final GetFxDataService getFxDataService;
    private final GetFxService getFxService;

    public void execute(BuyFxRequestDto request) {
        User user = currentUserProvider.getCurrentUser();

        FxData fxData = getFxDataService.getNewestFxDataByFxType(request.type());
        OwnFxVO ownFx = getFxService.getFxOwnDataByUserAndFxType(user, request.type());

        int fxPrice = fxData.getPrice();
        fxPrice *= (request.type().equals(FxType.JPY) ? request.amount() / 100 : request.amount());

        Fx fx = Fx.builder()
                .user(user)
                .type(request.type())
                .amount(ownFx.amount() + request.amount())
                .sumOfBuy(ownFx.sumOfBuy() + fxPrice)
                .build();

        user.setMoney(user.getMoney() - (long) fxPrice);

        commandFxService.saveFx(fx);
        commandUserService.saveUser(user);
    }
}
