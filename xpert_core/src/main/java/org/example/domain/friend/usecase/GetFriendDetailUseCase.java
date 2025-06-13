package org.example.domain.friend.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.friend.dto.response.GetFriendDetailResponseDto;
import org.example.domain.friend.service.CheckFriendService;
import org.example.domain.user.model.User;
import org.example.domain.user.service.GetUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetFriendDetailUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final GetUserService getUserService;
    private final CheckFriendService checkFriendService;

    public GetFriendDetailResponseDto execute(String friendId) {
        User currentUser = currentUserProvider.getCurrentUser();
        User user = getUserService.getUserByUserId(friendId);
        checkFriendService.checkFriendExists(currentUser, user);

        return GetFriendDetailResponseDto.from(user);
    }
}
