package org.example.domain.account.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.account.exception.errorCode.AccountErrorCode;

public class NotOwnerOfAccountException extends GlobalBusinessException {
    public static final NotOwnerOfAccountException EXCEPTION = new NotOwnerOfAccountException();

    public NotOwnerOfAccountException() { super(AccountErrorCode.NOT_OWNER_OF_ACCOUNT); }
}
