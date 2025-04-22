package org.example.post.repository;

import org.example.post.entity.PostJpaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PostJpaRepository extends CrudRepository<PostJpaEntity, UUID> {
}
