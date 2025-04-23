package org.example.domain.post.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.post.exception.IsNotWriterException;
import org.example.domain.post.model.Post;
import org.example.domain.post.service.CommandPostService;
import org.example.domain.post.service.GetPostService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class DeletePostUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final GetPostService getPostService;
    private final CommandPostService commandPostService;

    public void execute(UUID postId) {
        String userId = currentUserProvider.getCurrentUserId();
        Post post = getPostService.getPostByPostId(postId);

        if (!userId.equals(post.user().userId())) {
            throw IsNotWriterException.EXCEPTION;
        }

        commandPostService.deletePost(post);
    }
}
