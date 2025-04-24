package org.example.domain.comment.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.comment.dto.response.UpdateCommentRequestDto;
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
public class UpdateCommentUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final GetCommentService getCommentService;
    private final CheckCommentService checkCommentService;
    private final CommandCommentService commandCommentService;

    public void execute(UUID commentId, UpdateCommentRequestDto request) {
        User user = currentUserProvider.getCurrentUser();
        Comment comment = getCommentService.findCommentByCommentId(commentId);

        checkCommentService.CheckUserIsOwnerOfComment(user, comment);

        comment.setContent(request.content());
        commandCommentService.saveComment(comment);
    }
}
