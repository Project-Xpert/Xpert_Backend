package org.example.friend.repository;

import org.example.friend.entity.FriendId;
import org.example.friend.entity.FriendJpaEntity;
import org.example.user.entity.UserJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FriendJpaRepository extends CrudRepository<FriendJpaEntity, FriendId> {

    @Query("""
        SELECT f
        FROM friend f
        WHERE f.requester = :user1 AND f.receiver = :user2
           OR f.requester = :user2 AND f.receiver = :user1
    """)
    Optional<FriendJpaEntity> findByUsers(
        @Param("user1") UserJpaEntity user1,
        @Param("user2") UserJpaEntity user2
    );

    @Query("""
        SELECT u
        FROM user u INNER JOIN friend f ON u = f.requester
        WHERE f.receiver = :receiver
          AND NOT f.isAccepted
    """)
    List<UserJpaEntity> getAllRequestersByReceiver(@Param("receiver") UserJpaEntity receiver);

    @Query("""
        SELECT DISTINCT u
        FROM user u INNER JOIN friend f ON (u = f.requester OR u = f.receiver)
        WHERE (f.receiver = :user OR f.requester = :user) AND f.isAccepted AND u != :user
          AND (u.userId LIKE CONCAT('%', :keyword, '%')
          OR u.username LIKE CONCAT('%', :keyword, '%'))
    """)
    List<UserJpaEntity> findAcceptedFriendUsersByUserByKeyword(
            @Param("user") UserJpaEntity user,
            @Param("keyword") String keyword
    );
}
