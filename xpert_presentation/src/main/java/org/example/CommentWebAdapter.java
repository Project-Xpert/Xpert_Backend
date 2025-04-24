package org.example;

import lombok.RequiredArgsConstructor;
import org.example.domain.comment.dto.response.CreateCommentRequestDto;
import org.example.domain.comment.usecase.CreateCommentUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentWebAdapter {
    private final CreateCommentUseCase createCommentUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{postId}")
    public void creatComment(
        @PathVariable("postId") UUID postId,
        @Validated @RequestBody CreateCommentRequestDto request
    ) {
        createCommentUseCase.execute(postId, request);
    }
}
