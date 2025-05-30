package org.example.reply.repository;

import org.example.comment.entity.CommentJpaEntity;
import org.example.domain.reply.spi.vo.ReplyDataWithLikeCntVO;
import org.example.reply.entity.ReplyJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ReplyJpaRepository extends CrudRepository<ReplyJpaEntity, UUID> {

    int countByComment(CommentJpaEntity comment);

    @Query("""
        SELECT new org.example.domain.reply.spi.vo.ReplyDataWithLikeCntVO(
            c.commentId,
            r.replyId,
            r.user.userId,
            r.user.username,
            r.user.profile,
            r.content,
            r.createdAt,
            count(r_like)
        )
        FROM reply r
            LEFT OUTER JOIN replyLike r_like
            ON r.replyId = r_like.reply.replyId
            INNER JOIN comment c
            ON c.commentId = r.comment.commentId
            INNER JOIN post p
            ON c.post.postId = p.postId
        WHERE p.postId = :postId
        GROUP BY c.commentId, r.replyId, r.user.userId, r.user.username, r.user.profile, r.content, r.createdAt
    """)
    List<ReplyDataWithLikeCntVO> getReplyStatusListByPostId(@Param("postId") UUID postId);
}
