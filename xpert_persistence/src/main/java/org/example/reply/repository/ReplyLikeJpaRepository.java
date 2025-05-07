package org.example.reply.repository;

import org.example.reply.entity.ReplyLIkeId;
import org.example.reply.entity.ReplyLikeJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface ReplyLikeJpaRepository extends CrudRepository<ReplyLikeJpaEntity, ReplyLIkeId> {
}
