package org.example.domain.comment.spi;

import org.example.domain.comment.model.Comment;
import org.example.domain.comment.model.CommentLike;
import org.example.domain.user.model.User;

public interface QueryCommentLikePort {

    Boolean existsByCommentAndUser(Comment comment, User user);

    void saveCommentLike(CommentLike commentLike);

    void deleteCommentLike(CommentLike commentLike);
}
