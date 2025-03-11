package org.example.common.service;

import jakarta.mail.internet.MimeMessage;

public interface MailService {

    void sendMail(MimeMessage message);

    MimeMessage makeMailForm(String content, String requestEmail);
}
