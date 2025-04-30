package org.example.domain.post.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.post.model.Post;
import org.example.domain.post.model.PostLike;
import org.example.domain.post.service.CheckPostLikeService;
import org.example.domain.post.service.CommandPostLikeService;
import org.example.domain.post.service.GetPostService;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class TogglePostLikeUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final CommandPostLikeService commandPostLikeService;
    private final CheckPostLikeService checkPostLikeService;
    private final GetPostService getPostService;

    public void execute(UUID postId) {
        User user = currentUserProvider.getCurrentUser();
        Post post = getPostService.getPostByPostId(postId);

        PostLike like = PostLike.builder()
                .post(post)
                .user(user)
                .build();

        if (checkPostLikeService.getBooleanOfExistsByPostAndUser(post, user)) {
            commandPostLikeService.deletePostLike(like);
        } else {
            commandPostLikeService.savePostLike(like);
        }
    }
}
