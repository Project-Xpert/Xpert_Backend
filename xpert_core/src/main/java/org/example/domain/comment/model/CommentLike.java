package org.example.domain.comment.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.domain.user.model.User;

@Setter
@Getter
@Builder
public class CommentLike {

    private Comment comment;

    private User user;
}
