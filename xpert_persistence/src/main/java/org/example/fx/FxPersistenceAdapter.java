package org.example.fx;

import lombok.RequiredArgsConstructor;
import org.example.domain.fx.model.Fx;
import org.example.domain.fx.model.FxType;
import org.example.domain.fx.spi.QueryFxPort;
import org.example.domain.fx.spi.vo.OwnFxVO;
import org.example.domain.user.model.User;
import org.example.fx.entity.FxId;
import org.example.fx.mapper.FxMapper;
import org.example.fx.repository.FxJpaRepository;
import org.example.user.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FxPersistenceAdapter implements QueryFxPort {
    private final FxJpaRepository fxJpaRepository;
    private final UserMapper userMapper;
    private final FxMapper fxMapper;

    @Override
    public OwnFxVO getFxOwnDataByUserAndFxType(User user, FxType fxType) {
        return fxJpaRepository.getFxOwnDataByUserAndFxType(
            userMapper.toEntity(user),
            fxType
        ).orElse(new OwnFxVO(0, 0));
    }

    @Override
    public void save(Fx fx) {
        fxJpaRepository.save(fxMapper.toEntity(fx));
    }

    @Override
    public void deleteByFxTypeAndUser(FxType type, User user) {
        fxJpaRepository.deleteById(new FxId(type, userMapper.toEntity(user)));
    }

    @Override
    public Optional<Fx> getFxByUserAndFxType(FxType type, User user) {
        return fxMapper.toDomain(
                fxJpaRepository.findById(
                        new FxId(type, userMapper.toEntity(user))
                )
        );
    }
}
