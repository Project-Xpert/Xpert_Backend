package org.example.domain.post.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.common.service.FileService;
import org.example.domain.post.dto.request.UpdatePostRequestDto;
import org.example.domain.post.model.Post;
import org.example.domain.post.service.CheckPostService;
import org.example.domain.post.service.CommandPostService;
import org.example.domain.post.service.GetPostService;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdatePostUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final CommandPostService commandPostService;
    private final GetPostService getPostService;
    private final CheckPostService checkPostService;
    private final FileService fileService;

    public void execute(UUID postId, MultipartFile file, UpdatePostRequestDto request) {
        User user = currentUserProvider.getCurrentUser();
        Post post = getPostService.getPostByPostId(postId);

        checkPostService.checkUserIsOwnerOfPost(user, post);

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
