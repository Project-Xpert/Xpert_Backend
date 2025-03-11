package org.example.global.thirdparty.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.example.common.exception.general.InternalServerException;
import org.example.common.service.MailService;
import org.example.global.thirdparty.mail.exception.MailNotValidException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {
    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String senderMail;

    @Override
    public void sendMail(MimeMessage message) {
        javaMailSender.send(message);
    }

    @Override
    public MimeMessage makeMailForm(String content, String requestMail) {
        this.checkMailIsValid(requestMail);

        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            message.addRecipients(MimeMessage.RecipientType.TO, requestMail);
            message.setSubject("Xpert 인증번호입니다");
            message.setFrom(senderMail);
            message.setText(setContext(content), "utf-8", "html");

            return message;
        } catch (MessagingException e) {
            throw InternalServerException.EXCEPTION;
        }
    }

    private void checkMailIsValid(String mail) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if (mail == null || !mail.matches(emailRegex)) {
            throw MailNotValidException.EXCEPTION;
        }
    }

    private String setContext(String code) {
        return "<div style='font-size:16px; font-family:Arial, sans-serif;'>" +
                "Xpert 인증번호입니다: <strong>" + code + "</strong>" +
                "</div>";
    }
}