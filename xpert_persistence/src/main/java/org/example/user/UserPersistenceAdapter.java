package org.example.user;

import lombok.RequiredArgsConstructor;
import org.example.domain.user.model.User;
import org.example.domain.user.spi.QueryUserPort;
import org.example.user.mapper.UserMapper;
import org.example.user.repository.UserJpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserPersistenceAdapter implements QueryUserPort {
    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;

    @Override
    public Optional<User> getUserByUserId(String userId) {
        return userMapper.toDomain(
                userJpaRepository.findById(userId)
        );
    }
}
