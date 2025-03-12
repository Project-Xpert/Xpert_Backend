package org.example.domain.user.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.RedisService;
import org.example.domain.user.dto.request.VerifyCodeRequestDto;
import org.example.domain.user.exception.CodeNotMatchesException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VerifyCodeUseCase {
    private final RedisService redisService;

    public void execute(VerifyCodeRequestDto request) {
        String savedCode = redisService.getValueByKey(request.mail());

        if (!savedCode.equals(request.code())) {
            throw CodeNotMatchesException.EXCEPTION;
        }
    }
}
