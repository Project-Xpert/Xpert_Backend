package org.example.reply.repository;

import org.example.domain.user.model.User;
import org.example.reply.entity.ReplyLIkeId;
import org.example.reply.entity.ReplyLikeJpaEntity;
import org.example.user.entity.UserJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ReplyLikeJpaRepository extends CrudRepository<ReplyLikeJpaEntity, ReplyLIkeId> {

    @Query(value = """
        SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END
        FROM replyLike rl
        WHERE rl.reply.replyId = :replyId
          AND rl.user = :user
    """)
    boolean existsByReplyIdAndUser(@Param("replyId") UUID replyId, @Param("user") UserJpaEntity user);
}
