package org.example.domain.gold.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.gold.dto.response.GetOwnGoldDataResponseDto;
import org.example.domain.gold.model.Gold;
import org.example.domain.gold.model.GoldType;
import org.example.domain.gold.service.GetGoldService;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetOwnGoldDataUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final GetGoldService getGoldService;

    public GetOwnGoldDataResponseDto execute() {
        User user = currentUserProvider.getCurrentUser();
        List<Gold> goldData = new ArrayList<>();

        for (GoldType type: GoldType.values()) {
            Gold gold = getGoldService.getOptionalOfGoldByGoldTypeAndUser(type, user)
                    .orElseGet(() -> createEmptyGold(type));

            goldData.add(gold);
        }

        return GetOwnGoldDataResponseDto.of(user.money(), goldData);
    }

    private Gold createEmptyGold(GoldType type) {
        return Gold.builder()
                .goldType(type)
                .cnt(0)
                .build();
    }
}
