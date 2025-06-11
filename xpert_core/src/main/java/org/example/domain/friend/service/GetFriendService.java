package org.example.domain.friend.service;

import org.example.domain.friend.modal.Friend;
import org.example.domain.user.model.User;

public interface GetFriendService {

    Friend getFriendByRequesterAndReceiver(User requester, User receiver);
}
