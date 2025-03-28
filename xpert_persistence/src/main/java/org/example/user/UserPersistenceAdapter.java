package org.example.user;

import lombok.RequiredArgsConstructor;
import org.example.domain.user.model.User;
import org.example.domain.user.spi.QueryUserPort;
import org.example.user.mapper.UserMapper;
import org.example.user.repository.UserJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
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

    @Override
    public Boolean checkUserExistsByUserId(String userId) {
        return userJpaRepository.existsById(userId);
    }

    @Override
    public Boolean checkUserExistsByEmail(String email) {
        return userJpaRepository.existsByEmail(email);
    }

    @Override
    public void save(User user) {
        userJpaRepository.save(
                userMapper.toEntity(user)
        );
    }
}
