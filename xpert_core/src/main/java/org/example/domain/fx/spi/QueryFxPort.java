package org.example.domain.fx.spi;

import org.example.domain.fx.spi.vo.OwnFxVO;
import org.example.domain.user.model.User;

public interface QueryFxPort {

    OwnFxVO getFxOwnDataByUser(User user);
}
