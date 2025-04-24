package org.example.comment;

import lombok.RequiredArgsConstructor;
import org.example.comment.mapper.CommentMapper;
import org.example.comment.repository.CommentJpaRepository;
import org.example.domain.comment.model.Comment;
import org.example.domain.comment.spi.QueryCommentPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentPersistenceAdapter implements QueryCommentPort {
    private final CommentMapper commentMapper;
    private final CommentJpaRepository commentJpaRepository;

    @Override
    public void saveComment(Comment comment) {
        commentJpaRepository.save(commentMapper.toEntity(comment));
    }
}
