package org.example;

import lombok.RequiredArgsConstructor;
import org.example.domain.reply.dto.request.CreateReplyRequestDto;
import org.example.domain.reply.usecase.CreateReplyUseCase;
import org.example.domain.reply.usecase.DeleteReplyUseCase;
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
}
