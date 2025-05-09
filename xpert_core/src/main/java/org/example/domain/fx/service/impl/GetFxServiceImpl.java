package org.example.domain.fx.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.fx.model.FxType;
import org.example.domain.fx.service.GetFxService;
import org.example.domain.fx.spi.QueryFxPort;
import org.example.domain.fx.spi.vo.OwnFxVO;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetFxServiceImpl implements GetFxService {
    private final QueryFxPort queryFxPort;

    @Override
    public OwnFxVO getFxOwnDataByUserAndFxType(User user, FxType fxType) {
        return queryFxPort.getFxOwnDataByUserAndFxType(user, fxType);
    }
}
