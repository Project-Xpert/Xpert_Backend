package org.example.domain.friend.spi;

import org.example.domain.friend.modal.Friend;
import org.example.domain.user.model.User;

public interface QueryFriendPort {
    void saveFriend(Friend friend);

    boolean checkFriendExists(User requester, User receiver);
}
