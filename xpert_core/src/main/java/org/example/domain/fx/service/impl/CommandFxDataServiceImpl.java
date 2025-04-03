package org.example.domain.fx.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.fx.model.FxData;
import org.example.domain.fx.service.CommandFxDataService;
import org.example.domain.fx.spi.QueryFxDataPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandFxDataServiceImpl implements CommandFxDataService {
    private final QueryFxDataPort queryFxDataPort;

    @Override
    public void saveFxData(FxData fxData) {
        queryFxDataPort.saveFxData(fxData);
    }

    @Override
    public void delete(FxData fxData) {
        queryFxDataPort.delete(fxData);
    }
}
