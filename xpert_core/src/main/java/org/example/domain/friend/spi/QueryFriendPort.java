package org.example.domain.friend.spi;

import org.example.domain.friend.modal.Friend;
import org.example.domain.user.model.User;

import java.util.List;
import java.util.Optional;

public interface QueryFriendPort {
    void saveFriend(Friend friend);

    void deleteFriend(Friend friend);

    boolean checkFriendExists(User user1, User user2);

    Optional<Friend> findFriendByUsers(User user1, User user2);

    List<User> getRequestersByReceiver(User user);

    Optional<Friend> findFriendByRequesterAndReceiver(User requester, User receiver);

    List<User> findAcceptedFriendUsersByUserByKeyword(User user, String keyword);
}
