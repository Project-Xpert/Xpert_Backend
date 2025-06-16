package org.example.domain.friend.service;

import org.example.domain.friend.modal.Friend;
import org.example.domain.user.model.User;

import java.util.List;

public interface GetFriendService {

    Friend findFriendsByUsers(User user1, User user2);

    List<User> getRequestersByReceiver(User user);

    Friend findFriendsByRequesterAndReceiver(User requester, User receiver);

    List<User> findAcceptedFriendUsersByUserByKeyword(User user, String keyword);

    List<User> getFriendUsersRankingByUser(User user);
}
