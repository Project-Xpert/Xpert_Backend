package org.example.domain.gold.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.gold.dto.request.BuyGoldRequestDto;
import org.example.domain.gold.model.Gold;
import org.example.domain.gold.service.CommandGoldService;
import org.example.domain.gold.service.GetGoldService;
import org.example.domain.user.exception.RunOutOfMoneyException;
import org.example.domain.user.model.User;
import org.example.domain.user.service.CommandUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BuyGoldUseCase {
    private final CommandUserService commandUserService;
    private final CommandGoldService commandGoldService;
    private final CurrentUserProvider currentUserProvider;
    private final GetGoldService getGoldService;

    public void execute(BuyGoldRequestDto request) {
        User user = currentUserProvider.getCurrentUser();
        Optional<Gold> optionalGold = getGoldService.getOptionalOfGoldByGoldTypeAndUser(request.goldType(), user);
        int prevCnt = optionalGold.map(Gold::cnt).orElse(0);
        long totalGoldPrice = (long) request.cnt() * request.price();

        if (user.money() < totalGoldPrice) {
            throw RunOutOfMoneyException.EXCEPTION;
        }

        commandGoldService.saveGold(Gold.builder()
                    .goldType(request.goldType())
                    .userId(user.userId())
                    .cnt(prevCnt + request.cnt())
                    .build()
        );

        commandUserService.saveUser(User.builder()
                    .userId(user.userId())
                    .username(user.username())
                    .email(user.email())
                    .password(user.password())
                    .profile(user.profile())
                    .money(user.money() - totalGoldPrice)
                    .build()
        );
    }
}
