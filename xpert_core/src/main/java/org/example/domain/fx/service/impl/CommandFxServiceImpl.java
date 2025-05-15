package org.example.domain.fx.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.fx.model.Fx;
import org.example.domain.fx.model.FxType;
import org.example.domain.fx.service.CommandFxService;
import org.example.domain.fx.spi.QueryFxPort;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandFxServiceImpl implements CommandFxService {
    private final QueryFxPort queryFxPort;

    @Override
    public void saveFx(Fx fx) {
        queryFxPort.save(fx);
    }

    @Override
    public void deleteByFxTypeAndUser(FxType type, User user) {
        queryFxPort.deleteByFxTypeAndUser(type, user);
    }
}
