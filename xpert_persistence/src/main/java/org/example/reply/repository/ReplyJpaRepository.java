package org.example.reply.repository;

import org.example.comment.entity.CommentJpaEntity;
import org.example.domain.comment.model.Comment;
import org.example.reply.entity.ReplyJpaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ReplyJpaRepository extends CrudRepository<ReplyJpaEntity, UUID> {

    int countByComment(CommentJpaEntity comment);
}
