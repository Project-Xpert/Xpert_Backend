package org.example.domain.comment.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.comment.exception.IsNotOwnerOfCommentException;
import org.example.domain.comment.model.Comment;
import org.example.domain.comment.service.CheckCommentService;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckCommentServiceImpl implements CheckCommentService {

    @Override
    public void CheckUserIsOwnerOfComment(User user, Comment comment) {
        if (!user.equals(comment.getUser())) {
            throw IsNotOwnerOfCommentException.EXCEPTION;
        }
    }
}
