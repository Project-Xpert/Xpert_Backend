package org.example.domain.friend.service;

import org.example.domain.user.model.User;

public interface CheckFriendService {

    void checkFriendAlreadyExists(User user1, User user2);
}
