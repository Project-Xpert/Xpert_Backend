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
public class DeleteFriendUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final CommandFriendService commandFriendService;
    private final GetFriendService getFriendService;
    private final GetUserService getUserService;

    public void execute(String  userId) {
        User currentUser = currentUserProvider.getCurrentUser();
        User targetUser = getUserService.getUserByUserId(userId);

        Friend friend = getFriendService.getFriendByRequesterAndReceiver(currentUser, targetUser);

        commandFriendService.deleteFriend(friend);
    }
}
