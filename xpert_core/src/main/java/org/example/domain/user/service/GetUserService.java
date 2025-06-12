package org.example.domain.user.service;

import org.example.domain.user.model.User;

import java.util.List;

public interface GetUserService {

    User getUserByUserId(String userId);

    List<User> getNonFriendUsersByUserAndKeyword(User user, String keyword);
}
