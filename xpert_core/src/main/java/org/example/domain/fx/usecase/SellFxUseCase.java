package org.example.domain.fx.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.fx.dto.request.SellFxRequestDto;
import org.example.domain.fx.model.Fx;
import org.example.domain.fx.model.FxData;
import org.example.domain.fx.model.FxType;
import org.example.domain.fx.service.CheckFxService;
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
public class SellFxUseCase {
    private final GetFxService getFxService;
    private final CheckFxService checkFxService;
    private final GetFxDataService getFxDataService;
    private final CommandFxService commandFxService;
    private final CommandUserService commandUserService;
    private final CurrentUserProvider currentUserProvider;

    public void execute(SellFxRequestDto request) {
        User user = currentUserProvider.getCurrentUser();

        Fx fx = getFxService.getFxByUserAndFxType(user, request.type());
        FxData fxData = getFxDataService.getNewestFxDataByFxType(request.type());

        checkFxService.checkFxIsEnough(fx.getAmount(), request.amount());

        int fxPrice = fxData.getSellPrice();
        fxPrice *= request.type().equals(FxType.JPY) ? request.amount() / 100 : request.amount();

        // 만약 다 팔면 컬럼 자체를 삭제하고, 일부만 판다면 그만큼만 차감시키기
        if (fx.getAmount() == request.amount()) {
            commandFxService.deleteByFxTypeAndUser(request.type(), user);
        } else {
            int avgPrice = fx.getSumOfBuy() / fx.getAmount();

            fx.setAmount(fx.getAmount() - request.amount());
            fx.setSumOfBuy(fx.getSumOfBuy() - avgPrice * request.amount());

            commandFxService.saveFx(fx);
        }

        user.setMoney(user.getMoney() + (long) fxPrice);
        commandUserService.saveUser(user);
    }
}
