package org.example.domain.gold.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.gold.model.Gold;
import org.example.domain.gold.service.CommandGoldService;
import org.example.domain.gold.spi.QueryGoldPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandGoldServiceImpl implements CommandGoldService {
    private final QueryGoldPort queryGoldPort;

    @Override
    public void saveGold(Gold gold) {
        queryGoldPort.saveGold(gold);
    }
}
