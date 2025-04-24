package org.example.reply.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.user.entity.UserJpaEntity;

import java.io.Serializable;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ReplyLIkeId implements Serializable {

    private ReplyJpaEntity reply;

    private UserJpaEntity user;
}
