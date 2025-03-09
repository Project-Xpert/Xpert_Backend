package org.example.global.security.auth;

import lombok.RequiredArgsConstructor;
import org.example.domain.user.exception.UserNotFoundException;
import org.example.domain.user.spi.QueryUserPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService {
    private final QueryUserPort queryUserPort;

    public CustomUserDetails getUserDetailsByUserId(String userId) {
        if (!queryUserPort.checkUserExistsByUserId(userId)) {
            throw UserNotFoundException.EXCEPTION;
        }

        return new CustomUserDetails(userId);
    }
}
