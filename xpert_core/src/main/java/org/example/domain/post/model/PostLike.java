package org.example.domain.post.model;

import lombok.Builder;
import org.example.domain.user.model.User;

@Builder
public record PostLike(
    User user,
    Post post
) {
}
