package org.example.domain.fx.spi;

import org.example.domain.fx.model.Fx;
import org.example.domain.fx.model.FxType;
import org.example.domain.fx.spi.vo.OwnFxVO;
import org.example.domain.user.model.User;

import java.util.Optional;

public interface QueryFxPort {

    OwnFxVO getFxOwnDataByUserAndFxType(User user, FxType fxType);

    void save(Fx fx);

    void deleteByFxTypeAndUser(FxType type, User user);

    Optional<Fx> getFxByUserAndFxType(FxType type, User user);
}
