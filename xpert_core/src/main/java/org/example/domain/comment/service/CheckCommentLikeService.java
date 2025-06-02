package org.example.domain.comment.service;

import org.example.domain.comment.model.Comment;
import org.example.domain.user.model.User;

public interface CheckCommentLikeService {

    Boolean getExistsResultByCommentAndUser(Comment comment, User user);
}
