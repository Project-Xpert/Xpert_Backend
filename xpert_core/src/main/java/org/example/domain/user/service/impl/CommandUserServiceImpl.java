package org.example.domain.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.user.model.User;
import org.example.domain.user.service.CommandUserService;
import org.example.domain.user.spi.QueryUserPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandUserServiceImpl implements CommandUserService {
    private final QueryUserPort queryUserPort;

    @Override
    public void saveUser(User user) {
        queryUserPort.save(user);
    }
}
