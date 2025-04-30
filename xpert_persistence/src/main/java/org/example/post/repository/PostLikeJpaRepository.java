package org.example.post.repository;

import org.example.post.entity.LikeId;
import org.example.post.entity.PostLikeJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostLikeJpaRepository extends CrudRepository<PostLikeJpaEntity, LikeId> {
}
