package org.example.domain.friend.spi;

import org.example.domain.friend.modal.Friend;
import org.example.domain.user.model.User;

import java.util.List;
import java.util.Optional;

public interface QueryFriendPort {
    void saveFriend(Friend friend);

    boolean checkFriendExists(User requester, User receiver);

    Optional<Friend> getFriendByRequesterAndReceiver(User requester, User receiver);

    void deleteFriend(Friend friend);

    List<User> getRequestersByReceiver(User user);
}
