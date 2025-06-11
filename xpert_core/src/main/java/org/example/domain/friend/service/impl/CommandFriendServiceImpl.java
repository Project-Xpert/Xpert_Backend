package org.example.domain.friend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.friend.modal.Friend;
import org.example.domain.friend.service.CommandFriendService;
import org.example.domain.friend.spi.QueryFriendPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandFriendServiceImpl implements CommandFriendService {
    private final QueryFriendPort queryFriendPort;

    @Override
    public void saveFriend(Friend friend) {
        queryFriendPort.saveFriend(friend);
    }
}
