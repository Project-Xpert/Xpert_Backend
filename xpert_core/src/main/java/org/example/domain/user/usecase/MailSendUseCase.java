package org.example.domain.user.usecase;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.example.common.service.MailService;
import org.example.common.service.RedisService;
import org.example.common.util.RandomCodeGenerator;
import org.example.domain.user.dto.request.MailSendRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MailSendUseCase {
    private final MailService mailService;
    private final RedisService redisService;

    public void execute(MailSendRequestDto request) {
        String code = RandomCodeGenerator.generate();

        MimeMessage message = mailService.makeMailForm(code, request.mail());
        mailService.sendMail(message);

        redisService.saveData(request.mail(), code, 2 * 60);
    }
}
