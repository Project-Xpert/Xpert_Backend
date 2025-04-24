package org.example;

import lombok.RequiredArgsConstructor;
import org.example.domain.comment.dto.response.CreateCommentRequestDto;
import org.example.domain.comment.dto.response.UpdateCommentRequestDto;
import org.example.domain.comment.usecase.CreateCommentUseCase;
import org.example.domain.comment.usecase.DeleteCommentUseCase;
import org.example.domain.comment.usecase.UpdateCommentUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentWebAdapter {
    private final CreateCommentUseCase createCommentUseCase;
    private final DeleteCommentUseCase deleteCommentUseCase;
    private final UpdateCommentUseCase updateCommentUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{postId}")
    public void createComment(
        @PathVariable("postId") UUID postId,
        @Validated @RequestBody CreateCommentRequestDto request
    ) {
        createCommentUseCase.execute(postId, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable("commentId") UUID commentId) {
        deleteCommentUseCase.execute(commentId);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{commentId}")
    public void updateComment(
        @PathVariable("commentId") UUID commentId,
        @Validated @RequestBody UpdateCommentRequestDto request
    ) {
        updateCommentUseCase.execute(commentId, request);
    }
}
