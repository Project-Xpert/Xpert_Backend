package org.example.domain.friend.service;

import org.example.domain.friend.modal.Friend;
import org.example.domain.user.model.User;

import java.util.List;

public interface GetFriendService {

    Friend getFriendByRequesterAndReceiver(User requester, User receiver);

    List<User> getRequestersByReceiver(User user);
}
