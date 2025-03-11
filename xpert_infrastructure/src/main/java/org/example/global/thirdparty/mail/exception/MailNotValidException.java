package org.example.global.thirdparty.mail.exception;

import org.example.common.exception.GlobalBusinessException;

public class MailNotValidException extends GlobalBusinessException {
    public static final MailNotValidException EXCEPTION = new MailNotValidException();

    public MailNotValidException() { super(MailErrorCode.EMAIL_NOT_VALID); }
}
