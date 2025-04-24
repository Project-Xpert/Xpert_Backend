package org.example.domain.reply.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.comment.model.Comment;
import org.example.domain.comment.service.GetCommentService;
import org.example.domain.reply.dto.request.CreateReplyRequestDto;
import org.example.domain.reply.model.Reply;
import org.example.domain.reply.service.CommandReplyService;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateReplyUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final GetCommentService getCommentService;
    private final CommandReplyService commandReplyService;

    public void execute(UUID commentId, CreateReplyRequestDto request) {
        User user = currentUserProvider.getCurrentUser();
        Comment comment = getCommentService.findCommentByCommentId(commentId);

        commandReplyService.saveReply(Reply.builder()
                        .user(user)
                        .comment(comment)
                        .content(request.content())
                        .build()
        );
    }
}
