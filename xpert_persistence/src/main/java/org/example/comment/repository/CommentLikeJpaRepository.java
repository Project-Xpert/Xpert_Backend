package org.example.comment.repository;

import org.example.comment.entity.CommentLikeId;
import org.example.domain.comment.model.CommentLike;
import org.springframework.data.repository.CrudRepository;

public interface CommentLikeJpaRepository extends CrudRepository<CommentLike, CommentLikeId> {
}
