package org.example.domain.gold.spi;

import org.example.domain.gold.model.Gold;
import org.example.domain.gold.model.GoldType;
import org.example.domain.user.model.User;

import java.util.Optional;

public interface QueryGoldPort {

    void saveGold(Gold gold);

    Optional<Gold> getGoldByGoldTypeAndUser(GoldType goldType, User user);
}
