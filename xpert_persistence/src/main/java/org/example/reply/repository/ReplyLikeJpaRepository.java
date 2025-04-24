package org.example.reply.repository;

import org.example.domain.reply.model.ReplyLike;
import org.example.reply.entity.ReplyLIkeId;
import org.springframework.data.repository.CrudRepository;

public interface ReplyLikeJpaRepository extends CrudRepository<ReplyLike, ReplyLIkeId> {
}
