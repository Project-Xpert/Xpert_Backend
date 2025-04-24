package org.example.domain.comment.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.comment.dto.response.CreateCommentRequestDto;
import org.example.domain.comment.model.Comment;
import org.example.domain.comment.service.CommandCommentService;
import org.example.domain.post.model.Post;
import org.example.domain.post.service.GetPostService;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateCommentUseCase {
    private final CommandCommentService commandCommentService;
    private final CurrentUserProvider currentUserProvider;
    private final GetPostService getPostService;

    public void execute(UUID postId, CreateCommentRequestDto request) {
        User user = currentUserProvider.getCurrentUser();
        Post post = getPostService.getPostByPostId(postId);

        commandCommentService.saveComment(Comment.builder()
                        .content(request.content())
                        .user(user)
                        .post(post)
                        .build()
        );
    }
}
