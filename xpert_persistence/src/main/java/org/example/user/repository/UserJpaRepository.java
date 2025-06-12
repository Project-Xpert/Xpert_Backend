package org.example.user.repository;

import org.example.domain.friend.spi.vo.AddFriendListItemVO;
import org.example.user.entity.UserJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserJpaRepository extends CrudRepository<UserJpaEntity, String> {
    Boolean existsByEmail(String email);

    @Query("""
        SELECT DISTINCT NEW org.example.domain.friend.spi.vo.AddFriendListItemVO(
            u.userId,
            u.username,
            u.profile,
            CASE WHEN f.requester = :user AND NOT f.isAccepted THEN true
                 ELSE false END
        )
        FROM user u LEFT OUTER JOIN friend f
            ON u = f.receiver
        WHERE u != :user
          AND (f.requester = :user OR NOT EXISTS (SELECT 1 FROM friend f1 WHERE f1.requester = :user AND f1.receiver = u))
          AND NOT EXISTS (SELECT 1 FROM friend f2 WHERE f2.receiver = :user AND f2.requester = u)
          AND (f IS NULL OR NOT f.isAccepted)
          AND (u.userId LIKE CONCAT('%', :keyword, '%') OR
               u.username LIKE CONCAT('%', :keyword, '%'))
    """)
    List<AddFriendListItemVO> getFriendAddDataByUserAndKeyword(UserJpaEntity user, String keyword);
}
