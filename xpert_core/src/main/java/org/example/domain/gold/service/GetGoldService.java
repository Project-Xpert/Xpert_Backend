package org.example.domain.gold.service;

import org.example.domain.gold.model.Gold;
import org.example.domain.gold.model.GoldType;
import org.example.domain.user.model.User;

import java.util.Optional;

public interface GetGoldService {

    Optional<Gold> getOptionalOfGoldByGoldTypeAndUser(GoldType goldType, User user);
}
