package org.example.domain.fx.service.impl;

import org.example.domain.fx.exception.FxNotEnoughException;
import org.example.domain.fx.service.CheckFxService;
import org.springframework.stereotype.Service;

@Service
public class CheckFxServiceImpl implements CheckFxService {

    @Override
    public void checkFxIsEnough(int ownFx, int needFx) {
        if (ownFx < needFx) {
            throw FxNotEnoughException.EXCEPTION;
        }
    }
}
