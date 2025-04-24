package org.example.domain.post.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.domain.user.model.User;

@Setter
@Getter
@Builder
public class PostLike {

    private User user;

    private Post post;
}
