package org.example.domain.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.user.exception.EmailAlreadyExistsException;
import org.example.domain.user.exception.UserIdAlreadyExistsException;
import org.example.domain.user.service.CheckUserService;
import org.example.domain.user.spi.QueryUserPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckUserServiceImpl implements CheckUserService {
    private final QueryUserPort queryUserPort;

    @Override
    public void checkUserAlreadyExistsByUserId(String userId) {
        if (queryUserPort.checkUserExistsByUserId(userId)) {
            throw UserIdAlreadyExistsException.EXCEPTION;
        };
    }

    @Override
    public void checkUserAlreadyExistsByEmail(String email) {
        if (queryUserPort.checkUserExistsByEmail(email)) {
            throw EmailAlreadyExistsException.EXCEPTION;
        };
    }
}
