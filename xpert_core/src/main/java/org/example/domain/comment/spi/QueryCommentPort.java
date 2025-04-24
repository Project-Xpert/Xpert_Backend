package org.example.domain.comment.spi;

import org.example.domain.comment.model.Comment;

public interface QueryCommentPort {

    void saveComment(Comment comment);
}
