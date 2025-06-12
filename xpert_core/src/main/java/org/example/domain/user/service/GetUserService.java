package org.example.domain.user.service;

import org.example.domain.friend.spi.vo.AddFriendListItemVO;
import org.example.domain.user.model.User;

import java.util.List;

public interface GetUserService {

    User getUserByUserId(String userId);

    List<AddFriendListItemVO> getFriendAddDataByUserAndKeyword(User user, String keyword);
}
