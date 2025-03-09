package org.example.user.repository;

import org.example.user.entity.UserJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserJpaRepository extends CrudRepository<UserJpaEntity, String> {
}
