package org.example.fx;

import lombok.RequiredArgsConstructor;
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
    public OwnFxVO getFxOwnDataByUser(User user) {
        return fxJpaRepository.getFxOwnDataByUser(
            userMapper.toEntity(user)
        ).orElse(new OwnFxVO(0, 0));
    }
}
