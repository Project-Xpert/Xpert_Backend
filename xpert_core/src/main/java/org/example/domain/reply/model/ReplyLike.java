package org.example.domain.reply.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.domain.user.model.User;

@Setter
@Getter
@Builder
public class ReplyLike {

    private Reply reply;

    private User user;
}
