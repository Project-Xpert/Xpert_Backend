package org.example.comment.repository;

import org.example.comment.entity.CommentJpaEntity;
import org.example.post.entity.PostJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CommentJpaRepository extends CrudRepository<CommentJpaEntity, UUID> {

    @Query("SELECT count(c) + count(r) " +
            "FROM comment c INNER JOIN reply r ON c.commentId = r.comment.commentId " +
            "WHERE c.post = :post")
    int countTotalCommentAndReplyByPost(PostJpaEntity post);
}
