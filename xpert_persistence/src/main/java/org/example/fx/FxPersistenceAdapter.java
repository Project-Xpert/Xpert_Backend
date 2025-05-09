package org.example.fx;

import lombok.RequiredArgsConstructor;
import org.example.domain.fx.model.FxType;
import org.example.domain.fx.spi.QueryFxPort;
import org.example.domain.fx.spi.vo.OwnFxVO;
import org.example.domain.user.model.User;
import org.example.fx.mapper.FxMapper;
import org.example.fx.repository.FxJpaRepository;
import org.example.user.mapper.UserMapper;
import org.springframework.stereotype.Component;

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
}
