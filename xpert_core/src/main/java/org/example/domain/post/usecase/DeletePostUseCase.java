package org.example.domain.post.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.post.exception.IsNotOwnerOfPostException;
import org.example.domain.post.model.Post;
import org.example.domain.post.service.CheckPostService;
import org.example.domain.post.service.CommandPostService;
import org.example.domain.post.service.GetPostService;
import org.example.domain.user.model.User;
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
    private final CheckPostService checkPostService;

    public void execute(UUID postId) {
        User user = currentUserProvider.getCurrentUser();
        Post post = getPostService.getPostByPostId(postId);

        checkPostService.checkUserIsOwnerOfPost(user, post);

        commandPostService.deletePost(post);
    }
}
