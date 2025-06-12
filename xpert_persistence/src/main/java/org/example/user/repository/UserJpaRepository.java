package org.example.user.repository;

import org.example.domain.user.model.User;
import org.example.user.entity.UserJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserJpaRepository extends CrudRepository<UserJpaEntity, String> {
    Boolean existsByEmail(String email);

    @Query("""
        SELECT u
        FROM user u LEFT OUTER JOIN friend f
            ON u = f.receiver
            OR u = f.requester
        WHERE u != :user
          AND (f.receiver != :user OR f.receiver IS NULL)
          AND (f.requester != :user OR f.requester IS NULL)
          AND (u.userId LIKE CONCAT('%', :keyword, '%') OR
               u.username LIKE CONCAT('%', :keyword, '%'))
    """)
    List<UserJpaEntity> getNonFriendUsersByUserAndKeyword(UserJpaEntity user, String keyword);
}
