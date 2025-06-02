package org.example.comment.repository;

import org.example.comment.entity.CommentLikeId;
import org.example.comment.entity.CommentLikeJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface CommentLikeJpaRepository extends CrudRepository<CommentLikeJpaEntity, CommentLikeId> {
}
