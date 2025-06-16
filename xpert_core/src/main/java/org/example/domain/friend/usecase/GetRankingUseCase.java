package org.example.domain.friend.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.friend.dto.response.GetFriendRankingResponseDto;
import org.example.domain.friend.service.GetFriendService;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetRankingUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final GetFriendService getFriendService;

    public GetFriendRankingResponseDto execute() {
        User user = currentUserProvider.getCurrentUser();

        List<User> friends = getFriendService.getFriendUsersRankingByUser(user);

        return GetFriendRankingResponseDto.from(friends);
    }
}
