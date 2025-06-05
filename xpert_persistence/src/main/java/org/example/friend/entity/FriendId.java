package org.example.friend.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.user.entity.UserJpaEntity;

import java.io.Serializable;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class FriendId implements Serializable {

    private UserJpaEntity requester;

    private UserJpaEntity receiver;
}
