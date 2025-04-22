package org.example.domain.post.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.common.service.FileService;
import org.example.domain.post.dto.request.CreatePostRequestDto;
import org.example.domain.post.model.Post;
import org.example.domain.post.service.CommandPostService;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
@RequiredArgsConstructor
public class CreatePostUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final CommandPostService commandPostService;
    private final FileService fileService;

    public void execute(MultipartFile file, CreatePostRequestDto request) {
        User user = currentUserProvider.getCurrentUser();

        String fileUrl = null;
        if (file != null) {
            fileUrl = fileService.uploadFile(file);
        }

        commandPostService.savePost(Post.builder()
                    .user(user)
                    .title(request.title())
                    .content(request.content())
                    .file(fileUrl)
                    .build()
        );
    }
}
