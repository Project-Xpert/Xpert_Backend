package org.example.domain.user.usecase;

import lombok.RequiredArgsConstructor;
import org.example.domain.user.dto.request.CheckUniqueAttributeRequestDto;
import org.example.domain.user.service.CheckUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CheckUniqueAttributeUseCase {
    private final CheckUserService checkUserService;

    public void execute(CheckUniqueAttributeRequestDto request) {
        checkUserService.checkUserAlreadyExistsByUserId(request.userId());
        checkUserService.checkUserAlreadyExistsByEmail(request.email());
    }
}
