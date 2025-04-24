package org.example.domain.comment.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.comment.model.Comment;
import org.example.domain.comment.service.CheckCommentService;
import org.example.domain.comment.service.CommandCommentService;
import org.example.domain.comment.service.GetCommentService;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteCommentUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final CommandCommentService commandCommentService;
    private final GetCommentService getCommentService;
    private final CheckCommentService checkCommentService;

    public void execute(UUID commentId) {
        User user = currentUserProvider.getCurrentUser();
        Comment comment = getCommentService.findCommentByCommentId(commentId);

        checkCommentService.CheckUserIsOwnerOfComment(user, comment);

        commandCommentService.deleteComment(comment);
    }
}
