package org.example.domain.reply.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.reply.model.Reply;
import org.example.domain.reply.service.CheckReplyService;
import org.example.domain.reply.service.CommandReplyService;
import org.example.domain.reply.service.GetReplyService;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteReplyUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final CheckReplyService checkReplyService;
    private final GetReplyService getReplyService;
    private final CommandReplyService commandReplyService;

    public void execute(UUID replyId) {
        User user = currentUserProvider.getCurrentUser();
        Reply reply = getReplyService.getReplyByReplyId(replyId);

        checkReplyService.userIsOwnerOfReply(user, reply);

        commandReplyService.deleteReply(reply);
    }
}
