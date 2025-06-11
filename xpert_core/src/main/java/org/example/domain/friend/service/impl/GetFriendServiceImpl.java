package org.example.domain.friend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.friend.exception.FriendNotFoundException;
import org.example.domain.friend.modal.Friend;
import org.example.domain.friend.service.GetFriendService;
import org.example.domain.friend.spi.QueryFriendPort;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetFriendServiceImpl implements GetFriendService {
    private final QueryFriendPort queryFriendPort;

    @Override
    public Friend getFriendByRequesterAndReceiver(User requester, User receiver) {
        return queryFriendPort.getFriendByRequesterAndReceiver(requester, receiver)
                .orElseThrow(() -> FriendNotFoundException.EXCEPTION);
    }
}
