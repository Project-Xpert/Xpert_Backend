package org.example.friend.repository;

import org.example.friend.entity.FriendId;
import org.example.friend.entity.FriendJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface FriendJpaRepository extends CrudRepository<FriendJpaEntity, FriendId> {
}
