package org.example.domain.comment.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.comment.model.Comment;
import org.example.domain.comment.model.CommentLike;
import org.example.domain.comment.service.CheckCommentLikeService;
import org.example.domain.comment.service.CommandCommentLikeService;
import org.example.domain.comment.service.GetCommentService;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ToggleCommentLikeUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final GetCommentService getCommentService;
    private final CheckCommentLikeService checkCommentLikeService;
    private final CommandCommentLikeService commandCommentLikeService;

    public void execute(UUID commentId) {
        User user = currentUserProvider.getCurrentUser();
        Comment comment = getCommentService.findCommentByCommentId(commentId);

        CommentLike commentLike = CommentLike.builder()
                .comment(comment)
                .user(user)
                .build();

        if (checkCommentLikeService.getExistsResultByCommentAndUser(comment, user)) {
            commandCommentLikeService.deleteCommentLike(commentLike);
        } else {
            commandCommentLikeService.saveCommentLike(commentLike);
        }
    }
}
