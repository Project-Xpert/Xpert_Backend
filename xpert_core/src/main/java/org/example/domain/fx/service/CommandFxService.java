package org.example.domain.fx.service;

import org.example.domain.fx.model.Fx;
import org.example.domain.fx.model.FxType;
import org.example.domain.user.model.User;

public interface CommandFxService {

    void saveFx(Fx fx);

    void deleteByFxTypeAndUser(FxType type, User user);
}
