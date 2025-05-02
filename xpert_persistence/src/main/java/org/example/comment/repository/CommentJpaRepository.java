package org.example.comment.repository;

import org.example.comment.entity.CommentJpaEntity;
import org.example.domain.post.model.Post;
import org.example.post.entity.PostJpaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CommentJpaRepository extends CrudRepository<CommentJpaEntity, UUID> {

    int countByPost(PostJpaEntity post);
}
