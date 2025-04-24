package org.example.domain.comment.service;

import org.example.domain.comment.model.Comment;

public interface CommandCommentService {

    void saveComment(Comment comment);
}
