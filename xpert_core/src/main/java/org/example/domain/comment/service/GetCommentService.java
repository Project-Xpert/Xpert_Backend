package org.example.domain.comment.service;

import org.example.domain.comment.model.Comment;

import java.util.UUID;

public interface GetCommentService {

    Comment findCommentByCommentId(UUID commentId);
}
