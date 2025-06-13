package org.example.domain.friend.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.friend.modal.Friend;
import org.example.domain.friend.service.CommandFriendService;
import org.example.domain.friend.service.GetFriendService;
import org.example.domain.user.model.User;
import org.example.domain.user.service.GetUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AcceptFriendUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final GetUserService getUserService;
    private final GetFriendService getFriendService;
    private final CommandFriendService commandFriendService;

    public void execute(String userId) {
        User receiver = currentUserProvider.getCurrentUser();
        User requester = getUserService.getUserByUserId(userId);

        Friend friend = getFriendService.findFriendsByRequesterAndReceiver(requester, receiver);
        friend.setIsAccepted(true);

        commandFriendService.saveFriend(friend);
    }
}
