package org.example.domain.reply.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.reply.model.Reply;
import org.example.domain.reply.model.ReplyLike;
import org.example.domain.reply.service.CheckReplyLikeService;
import org.example.domain.reply.service.CommandReplyLikeService;
import org.example.domain.reply.service.GetReplyService;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ToggleReplyLikeUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final GetReplyService getReplyService;
    private final CheckReplyLikeService checkReplyLikeService;
    private final CommandReplyLikeService commandReplyLikeService;

    public void execute(UUID replyId) {
        User user = currentUserProvider.getCurrentUser();
        Reply reply = getReplyService.getReplyByReplyId(replyId);

        ReplyLike replyLike = ReplyLike.builder()
                .user(user)
                .reply(reply)
                .build();

        if (checkReplyLikeService.getBooleanOfExistsByReplyAndUser(reply, user)) {
            commandReplyLikeService.deleteReplyLike(replyLike);
        } else {
            commandReplyLikeService.saveReplyLike(replyLike);
        }
    }
}
