package org.example.domain.fx.service;

import org.example.domain.fx.model.Fx;
import org.example.domain.fx.model.FxType;
import org.example.domain.fx.spi.vo.OwnFxVO;
import org.example.domain.user.model.User;

public interface GetFxService {

    OwnFxVO getFxOwnDataByUserAndFxType(User user, FxType fxType);

    Fx getFxByUserAndFxType(User user, FxType type);
}
