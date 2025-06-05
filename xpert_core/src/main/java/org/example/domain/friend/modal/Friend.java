package org.example.domain.friend.modal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.domain.user.model.User;

@Getter
@Setter
@Builder
public class Friend {

    private User user1;

    private User user2;
}
