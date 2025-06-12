package org.example.domain.friend.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.friend.dto.response.GetNonFriendUsersResponseDto;
import org.example.domain.friend.spi.vo.AddFriendListItemVO;
import org.example.domain.user.model.User;
import org.example.domain.user.service.GetUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetAddFriendListItemUseCase {
    private final GetUserService getUserService;
    private final CurrentUserProvider currentUserProvider;

    public GetNonFriendUsersResponseDto execute(String keyword) {
        User user = currentUserProvider.getCurrentUser();

        List<AddFriendListItemVO> userList = getUserService.getFriendAddDataByUserAndKeyword(user, keyword);

        return GetNonFriendUsersResponseDto.from(userList);
    }
}
