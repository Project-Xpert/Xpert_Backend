package org.example.friend.repository;

import org.example.friend.entity.FriendId;
import org.example.friend.entity.FriendJpaEntity;
import org.example.user.entity.UserJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface FriendJpaRepository extends CrudRepository<FriendJpaEntity, FriendId> {

    @Query("""
        SELECT f
        FROM friend f
        WHERE f.requester = :requester AND f.receiver = :receiver
           OR f.requester = :receiver AND f.receiver = :requester
    """)
    Optional<FriendJpaEntity> findByRequesterAndReceiver(
        @Param("requester") UserJpaEntity requester,
        @Param("receiver") UserJpaEntity receiver
    );
}
