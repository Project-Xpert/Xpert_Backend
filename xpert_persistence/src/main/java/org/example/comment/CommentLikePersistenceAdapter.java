package org.example.comment;

import lombok.RequiredArgsConstructor;
import org.example.comment.entity.CommentLikeId;
import org.example.comment.mapper.CommentLikeMapper;
import org.example.comment.mapper.CommentMapper;
import org.example.comment.repository.CommentLikeJpaRepository;
import org.example.domain.comment.model.Comment;
import org.example.domain.comment.model.CommentLike;
import org.example.domain.comment.spi.QueryCommentLikePort;
import org.example.domain.user.model.User;
import org.example.user.mapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentLikePersistenceAdapter implements QueryCommentLikePort {
    private final UserMapper userMapper;
    private final CommentMapper commentMapper;
    private final CommentLikeMapper commentLikeMapper;
    private final CommentLikeJpaRepository commentLikeJpaRepository;

    @Override
    public Boolean existsByCommentAndUser(Comment comment, User user) {
        return commentLikeJpaRepository.existsById(new CommentLikeId(
                commentMapper.toEntity(comment),
                userMapper.toEntity(user)
        ));
    }

    @Override
    public void saveCommentLike(CommentLike commentLike) {
        commentLikeJpaRepository.save(commentLikeMapper.toEntity(commentLike));
    }

    @Override
    public void deleteCommentLike(CommentLike commentLike) {
        commentLikeJpaRepository.delete(commentLikeMapper.toEntity(commentLike));
    }
}
