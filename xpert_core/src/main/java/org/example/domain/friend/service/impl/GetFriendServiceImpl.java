package org.example.domain.friend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.friend.exception.FriendNotFoundException;
import org.example.domain.friend.modal.Friend;
import org.example.domain.friend.service.GetFriendService;
import org.example.domain.friend.spi.QueryFriendPort;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetFriendServiceImpl implements GetFriendService {
    private final QueryFriendPort queryFriendPort;

    @Override
    public Friend findFriendsByUsers(User user1, User user2) {
        return queryFriendPort.findFriendByUsers(user1, user2)
                .orElseThrow(() -> FriendNotFoundException.EXCEPTION);
    }

    @Override
    public List<User> getRequestersByReceiver(User user) {
        return queryFriendPort.getRequestersByReceiver(user);
    }

    @Override
    public Friend findFriendsByRequesterAndReceiver(User requester, User receiver) {
        return queryFriendPort.findFriendByRequesterAndReceiver(requester, receiver)
                .orElseThrow(() -> FriendNotFoundException.EXCEPTION);
    }

    @Override
    public List<User> findAcceptedFriendUsersByUserByKeyword(User user, String keyword) {
        return queryFriendPort.findAcceptedFriendUsersByUserByKeyword(user, keyword);
    }
}
