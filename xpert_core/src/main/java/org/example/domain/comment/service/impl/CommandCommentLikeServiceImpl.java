package org.example.domain.comment.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.comment.model.CommentLike;
import org.example.domain.comment.service.CommandCommentLikeService;
import org.example.domain.comment.spi.QueryCommentLikePort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandCommentLikeServiceImpl implements CommandCommentLikeService {
    private final QueryCommentLikePort queryCommentLikePort;

    @Override
    public void saveCommentLike(CommentLike commentLike) {
        queryCommentLikePort.saveCommentLike(commentLike);
    }

    @Override
    public void deleteCommentLike(CommentLike commentLike) {
        queryCommentLikePort.deleteCommentLike(commentLike);
    }
}
