package org.example.domain.reply.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.domain.comment.model.Comment;
import org.example.domain.user.model.User;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@Builder
public class Reply {

    UUID replyId;

    User user;

    Comment comment;

    String content;

    LocalDate createAt;
}
