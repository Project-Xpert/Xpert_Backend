package org.example.gold;

import lombok.RequiredArgsConstructor;
import org.example.domain.gold.model.Gold;
import org.example.domain.gold.model.GoldType;
import org.example.domain.gold.spi.QueryGoldPort;
import org.example.domain.user.model.User;
import org.example.gold.entity.GoldId;
import org.example.gold.mapper.GoldMapper;
import org.example.gold.repository.GoldJpaRepository;
import org.example.user.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GoldPersistenceAdapter implements QueryGoldPort {
    private final GoldJpaRepository goldJpaRepository;
    private final GoldMapper goldMapper;
    private final UserMapper userMapper;

    @Override
    public void saveGold(Gold gold) {
        goldJpaRepository.save(
                goldMapper.toEntity(gold)
        );
    }

    @Override
    public Optional<Gold> getGoldByGoldTypeAndUser(GoldType goldType, User user) {
        return goldMapper.toDomain(
            goldJpaRepository.findById(
                new GoldId(goldType, userMapper.toEntity(user))
            )
        );
    }
}
