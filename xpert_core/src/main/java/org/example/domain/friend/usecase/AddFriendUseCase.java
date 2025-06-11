package org.example.domain.friend.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.friend.exception.FriendWithSelfNotAllowedException;
import org.example.domain.friend.modal.Friend;
import org.example.domain.friend.service.CheckFriendService;
import org.example.domain.friend.service.CommandFriendService;
import org.example.domain.user.model.User;
import org.example.domain.user.service.GetUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AddFriendUseCase {
    private final GetUserService getUserService;
    private final CurrentUserProvider currentUserProvider;
    private final CommandFriendService commandFriendService;
    private final CheckFriendService checkFriendService;

    public void execute(String userId) {
        User requester = currentUserProvider.getCurrentUser();
        User receiver = getUserService.getUserByUserId(userId);

        if (receiver.getUserId().equals(requester.getUserId())) {
            throw FriendWithSelfNotAllowedException.EXCEPTION;
        }

        checkFriendService.checkFriendAlreadyExists(requester, receiver);

        commandFriendService.saveFriend(Friend.builder()
                .requester(requester)
                .receiver(receiver)
                .build()
        );
    }
}
