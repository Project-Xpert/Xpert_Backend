package org.example.domain.comment.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.comment.model.Comment;
import org.example.domain.comment.service.CommandCommentService;
import org.example.domain.comment.spi.QueryCommentPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandCommentServiceImpl implements CommandCommentService {
    private final QueryCommentPort queryCommentPort;

    @Override
    public void saveComment(Comment comment) {
        queryCommentPort.saveComment(comment);
    }

    @Override
    public void deleteComment(Comment comment) {
        queryCommentPort.deleteComment(comment);
    }
}
