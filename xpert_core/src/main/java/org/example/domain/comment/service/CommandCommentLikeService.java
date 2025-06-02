package org.example.domain.comment.service;

import org.example.domain.comment.model.CommentLike;

public interface CommandCommentLikeService {

    void saveCommentLike(CommentLike commentLike);

    void deleteCommentLike(CommentLike commentLike);
}
