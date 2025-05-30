package org.example.comment.repository;

import org.example.comment.entity.CommentJpaEntity;
import org.example.domain.comment.spi.vo.CommentDataWithLikeCntVO;
import org.example.post.entity.PostJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CommentJpaRepository extends CrudRepository<CommentJpaEntity, UUID> {

    @Query("""
        SELECT COUNT(c) + COUNT(r)
        FROM comment c LEFT OUTER JOIN reply r ON (c = r.comment)
        WHERE c.post = :post
    """)
    int countTotalCommentAndReplyByPost(PostJpaEntity post);

    @Query("""
        SELECT new org.example.domain.comment.spi.vo.CommentDataWithLikeCntVO(
            c.commentId,
            c.user.userId,
            c.user.username,
            c.user.profile,
            c.content,
            c.createdAt,
            count(c_like)
        )
        FROM comment c
            LEFT OUTER JOIN commentLike c_like
            ON c.commentId = c_like.comment.commentId
            INNER JOIN post p
            ON c.post.postId = p.postId
        WHERE p.postId = :postId
        GROUP BY c.commentId, c.user.userId, c.user.username, c.user.profile, c.content, c.createdAt
    """)
    List<CommentDataWithLikeCntVO> getCommentStatusListByPostId(@Param("postId") UUID postId);
}
