package org.example.friend.mapper;

import lombok.RequiredArgsConstructor;
import org.example.GenericMapper;
import org.example.domain.friend.modal.Friend;
import org.example.friend.entity.FriendJpaEntity;
import org.example.user.entity.UserJpaEntity;
import org.example.user.mapper.UserMapper;
import org.example.user.repository.UserJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FriendMapper implements GenericMapper<Friend, FriendJpaEntity> {
    private final UserMapper userMapper;
    private final UserJpaRepository userJpaRepository;

    @Override
    public Optional<Friend> toDomain(Optional<FriendJpaEntity> entity) {
        if (entity.isEmpty()) {
            return Optional.empty();
        }

        FriendJpaEntity friendEntity = entity.get();

        return Optional.of(Friend.builder()
                .requester(userMapper.toDomain(Optional.of(friendEntity.getRequester())).get())
                .receiver(userMapper.toDomain(Optional.of(friendEntity.getReceiver())).get())
                .isAccepted(friendEntity.getIsAccepted())
                .build()
        );
    }

    @Override
    public FriendJpaEntity toEntity(Friend domain) {
        UserJpaEntity requesterEntity = userJpaRepository.findById(domain.getRequester().getUserId()).get();
        UserJpaEntity receiverEntity = userJpaRepository.findById(domain.getReceiver().getUserId()).get();

        return new FriendJpaEntity(
                requesterEntity,
                receiverEntity,
                domain.getIsAccepted()
        );
    }
}
