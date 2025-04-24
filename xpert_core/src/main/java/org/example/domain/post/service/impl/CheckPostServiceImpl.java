package org.example.domain.post.service.impl;

import org.example.domain.post.exception.IsNotOwnerOfPostException;
import org.example.domain.post.model.Post;
import org.example.domain.post.service.CheckPostService;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;

@Service
public class CheckPostServiceImpl implements CheckPostService {

    @Override
    public void checkUserIsOwnerOfPost(User user, Post post) {
        if (!user.getUserId().equals(post.getUser().getUserId())) {
            throw IsNotOwnerOfPostException.EXCEPTION;
        }
    }
}
