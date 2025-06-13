package org.example.domain.friend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.friend.exception.FriendAlreadyExistsException;
import org.example.domain.friend.exception.FriendNotFoundException;
import org.example.domain.friend.service.CheckFriendService;
import org.example.domain.friend.spi.QueryFriendPort;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckFriendServiceImpl implements CheckFriendService {
    private final QueryFriendPort queryFriendPort;

    @Override
    public void checkFriendAlreadyExists(User user1, User user2) {
        if (queryFriendPort.checkFriendExists(user1, user2)) {
            throw FriendAlreadyExistsException.EXCEPTION;
        }
    }

    @Override
    public void checkFriendExists(User user1, User user2) {
        if (!queryFriendPort.checkAcceptedFriendExists(user1, user2)) {
            throw FriendNotFoundException.EXCEPTION;
        }
    }
}
