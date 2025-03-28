package org.example.domain.gold.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.gold.model.Gold;
import org.example.domain.gold.model.GoldType;
import org.example.domain.gold.service.GetGoldService;
import org.example.domain.gold.spi.QueryGoldPort;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetGoldServiceImpl implements GetGoldService {
    private final QueryGoldPort queryGoldPort;

    @Override
    public Optional<Gold> getOptionalOfGoldByGoldTypeAndUser(GoldType goldType, User user) {
        return queryGoldPort.getGoldByGoldTypeAndUser(goldType, user);
    }
}
