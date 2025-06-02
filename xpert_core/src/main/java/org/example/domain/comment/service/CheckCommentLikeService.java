package org.example.domain.comment.service;

import org.example.domain.comment.model.Comment;
import org.example.domain.user.model.User;

import java.util.UUID;

public interface CheckCommentLikeService {

    boolean getExistsResultByCommentAndUser(Comment comment, User user);

    boolean getExistsResultByCommentIdAndUser(UUID commentId, User user);
}
