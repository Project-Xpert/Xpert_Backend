package org.example.domain.friend.modal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.domain.user.model.User;

@Getter
@Setter
@Builder
public class Friend {

    private User requester;

    private User receiver;

    private Boolean isAccepted;
}
