package org.example.comment;

import lombok.RequiredArgsConstructor;
import org.example.comment.mapper.CommentMapper;
import org.example.comment.repository.CommentJpaRepository;
import org.example.domain.comment.model.Comment;
import org.example.domain.comment.spi.QueryCommentPort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentPersistenceAdapter implements QueryCommentPort {
    private final CommentMapper commentMapper;
    private final CommentJpaRepository commentJpaRepository;

    @Override
    public void saveComment(Comment comment) {
        commentJpaRepository.save(commentMapper.toEntity(comment));
    }

    @Override
    public Optional<Comment> findCommentByCommentId(UUID commentId) {
        return commentMapper.toDomain(commentJpaRepository.findById(commentId));
    }

    @Override
    public void deleteComment(Comment comment) {
        commentJpaRepository.delete(commentMapper.toEntity(comment));
    }
}
