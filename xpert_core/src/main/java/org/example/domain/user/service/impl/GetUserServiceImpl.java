package org.example.domain.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.friend.spi.vo.AddFriendListItemVO;
import org.example.domain.user.exception.UserNotFoundException;
import org.example.domain.user.model.User;
import org.example.domain.user.service.GetUserService;
import org.example.domain.user.spi.QueryUserPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetUserServiceImpl implements GetUserService {
    private final QueryUserPort queryUserPort;

    @Override
    public User getUserByUserId(String userId) {
        return queryUserPort.getUserByUserId(userId).orElseThrow(
                () -> UserNotFoundException.EXCEPTION
        );
    }

    @Override
    public List<AddFriendListItemVO> getFriendAddDataByUserAndKeyword(User user, String keyword) {
        return queryUserPort.getFriendAddDataByUserAndKeyword(user, keyword);
    }
}
