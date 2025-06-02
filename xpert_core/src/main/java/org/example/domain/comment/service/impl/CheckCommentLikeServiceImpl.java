package org.example.domain.comment.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.comment.model.Comment;
import org.example.domain.comment.service.CheckCommentLikeService;
import org.example.domain.comment.spi.QueryCommentLikePort;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckCommentLikeServiceImpl implements CheckCommentLikeService {
    private final QueryCommentLikePort queryCommentLikePort;

    @Override
    public boolean getExistsResultByCommentAndUser(Comment comment, User user) {
        return queryCommentLikePort.existsByCommentAndUser(comment, user);
    }

    @Override
    public boolean getExistsResultByCommentIdAndUser(UUID commentId, User user) {
        return queryCommentLikePort.existsByCommentIdAndUser(commentId, user);
    }
}
