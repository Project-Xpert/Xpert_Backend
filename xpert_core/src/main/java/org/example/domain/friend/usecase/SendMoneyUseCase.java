package org.example.domain.friend.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.friend.dto.request.SendMoneyRequestDto;
import org.example.domain.friend.service.CheckFriendService;
import org.example.domain.user.exception.RunOutOfMoneyException;
import org.example.domain.user.model.User;
import org.example.domain.user.service.CommandUserService;
import org.example.domain.user.service.GetUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SendMoneyUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final GetUserService getUserService;
    private final CheckFriendService checkFriendService;
    private final CommandUserService commandUserService;

    public void execute(String friendId, SendMoneyRequestDto request) {
        User user = currentUserProvider.getCurrentUser();
        User friend = getUserService.getUserByUserId(friendId);

        checkFriendService.checkFriendExists(user, friend);

        if (user.getMoney() < request.money()) {
            throw RunOutOfMoneyException.EXCEPTION;
        }

        user.setMoney(user.getMoney() - request.money());
        friend.setMoney(friend.getMoney() + request.money());

        commandUserService.saveUser(user);
        commandUserService.saveUser(friend);
    }
}
