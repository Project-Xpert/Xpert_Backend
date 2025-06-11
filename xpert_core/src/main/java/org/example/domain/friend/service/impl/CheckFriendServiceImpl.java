package org.example.domain.friend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.friend.exception.FriendAlreadyExistsException;
import org.example.domain.friend.service.CheckFriendService;
import org.example.domain.friend.spi.QueryFriendPort;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckFriendServiceImpl implements CheckFriendService {
    private final QueryFriendPort queryFriendPort;

    @Override
    public void checkFriendAlreadyExists(User requester, User receiver) {
        if (queryFriendPort.checkFriendExists(requester, receiver)) {
            throw FriendAlreadyExistsException.EXCEPTION;
        }
    }
}
