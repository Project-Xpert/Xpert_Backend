package org.example;

import lombok.RequiredArgsConstructor;
import org.example.domain.post.dto.request.CreatePostRequestDto;
import org.example.domain.post.usecase.CreatePostUseCase;
import org.example.domain.post.usecase.DeletePostUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostWebAdapter {
    private final CreatePostUseCase createPostUseCase;
    private final DeletePostUseCase deletePostUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createPost(
        @RequestPart(value = "file", required = false) MultipartFile file,
        @Validated @RequestPart("body") CreatePostRequestDto request
    ) {
        createPostUseCase.execute(file, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable UUID postId) {
        deletePostUseCase.execute(postId);
    }
}
