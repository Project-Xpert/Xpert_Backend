package org.example.comment.repository;

import org.example.comment.entity.CommentLikeId;
import org.example.comment.entity.CommentLikeJpaEntity;
import org.example.domain.user.model.User;
import org.example.user.entity.UserJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface CommentLikeJpaRepository extends CrudRepository<CommentLikeJpaEntity, CommentLikeId> {

    @Query(value = """
        SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END
        FROM commentLike cl
        WHERE cl.comment.commentId = :commentId
          AND cl.user = :user
    """)
    Boolean existsByCommentIdAndUser(@Param("commentId") UUID commentId, @Param("user") UserJpaEntity user);
}
