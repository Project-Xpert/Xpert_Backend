package org.example.domain.user.spi;

import org.example.domain.user.model.User;

import java.util.List;
import java.util.Optional;

public interface QueryUserPort {

    Optional<User> getUserByUserId(String userId);

    Boolean checkUserExistsByUserId(String userId);

    Boolean checkUserExistsByEmail(String email);

    void save(User user);

    List<User> getNonFriendUsersByUserAndKeyword(User user, String keyword);
}
