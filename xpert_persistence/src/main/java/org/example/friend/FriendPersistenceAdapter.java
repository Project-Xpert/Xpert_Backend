package org.example.friend;

import lombok.RequiredArgsConstructor;
import org.example.domain.friend.modal.Friend;
import org.example.domain.friend.spi.QueryFriendPort;
import org.example.domain.user.model.User;
import org.example.friend.entity.FriendId;
import org.example.friend.mapper.FriendMapper;
import org.example.friend.repository.FriendJpaRepository;
import org.example.user.entity.UserJpaEntity;
import org.example.user.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FriendPersistenceAdapter implements QueryFriendPort {
    private final FriendJpaRepository friendJpaRepository;
    private final FriendMapper friendMapper;
    private final UserMapper userMapper;

    @Override
    public void saveFriend(Friend friend) {
        friendJpaRepository.save(friendMapper.toEntity(friend));
    }

    @Override
    public void deleteFriend(Friend friend) {
        friendJpaRepository.delete(friendMapper.toEntity(friend));
    }

    @Override
    public List<User> getRequestersByReceiver(User receiver) {
        UserJpaEntity receiverEntity = userMapper.toEntity(receiver);
        return friendJpaRepository.getAllRequestersByReceiver(receiverEntity).stream()
                .map(userEntity -> userMapper.toDomain(Optional.of(userEntity)).get())
                .toList();
    }

    @Override
    public Optional<Friend> findFriendByRequesterAndReceiver(User requester, User receiver) {
        UserJpaEntity requesterEntity = userMapper.toEntity(requester);
        UserJpaEntity receiverEntity = userMapper.toEntity(receiver);

        return friendMapper.toDomain(
                friendJpaRepository.findById(
                        new FriendId(requesterEntity, receiverEntity)
                )
        );
    }

    @Override
    public boolean checkFriendExists(User user1, User user2) {
        UserJpaEntity user1Entity = userMapper.toEntity(user1);
        UserJpaEntity user2Entity = userMapper.toEntity(user2);

        return friendJpaRepository.existsById(
            new FriendId(user1Entity, user2Entity)
        ) || friendJpaRepository.existsById(
            new FriendId(user2Entity, user1Entity)
        );
    }

    @Override
    public Optional<Friend> findFriendByUsers(User user1, User user2) {
        UserJpaEntity user1Entity = userMapper.toEntity(user1);
        UserJpaEntity user2Entity = userMapper.toEntity(user2);

        return friendMapper.toDomain(
                friendJpaRepository.findByUsers(user1Entity, user2Entity)
        );
    }
}
