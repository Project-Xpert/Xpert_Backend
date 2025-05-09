package org.example.domain.fx.service;

import org.example.domain.fx.spi.vo.OwnFxVO;
import org.example.domain.user.model.User;

public interface GetFxService {

    OwnFxVO getFxOwnDataByUser(User user);
}
