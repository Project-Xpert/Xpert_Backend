package org.example.domain.reply.service;

import org.example.domain.reply.model.Reply;
import org.example.domain.user.model.User;

import java.util.UUID;

public interface CheckReplyLikeService {

    boolean getExistsResultByReplyAndUser(Reply reply, User user);

    boolean getExistsResultByResultIdAndUser(UUID uuid, User user);
}
