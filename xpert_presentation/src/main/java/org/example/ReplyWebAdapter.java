package org.example;

import lombok.RequiredArgsConstructor;
import org.example.domain.reply.dto.request.CreateReplyRequestDto;
import org.example.domain.reply.dto.request.UpdateReplyRequestDto;
import org.example.domain.reply.usecase.CreateReplyUseCase;
import org.example.domain.reply.usecase.DeleteReplyUseCase;
import org.example.domain.reply.usecase.UpdateReplyUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyWebAdapter {
    private final CreateReplyUseCase createReplyUseCase;
    private final DeleteReplyUseCase deleteReplyUseCase;
    private final UpdateReplyUseCase updateReplyUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{commentId}")
    public void createReply(
        @PathVariable("commentId") UUID commentId,
        @Validated @RequestBody CreateReplyRequestDto request
    ) {
        createReplyUseCase.execute(commentId, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{replyId}")
    public void deleteReply(@PathVariable UUID replyId) {
        deleteReplyUseCase.execute(replyId);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{replyId}")
    public void updateReply(
        @PathVariable UUID replyId,
        @Validated @RequestBody UpdateReplyRequestDto request
    ) {
        updateReplyUseCase.execute(replyId, request);
    }
}
