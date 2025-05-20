package org.example.domain.account.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.account.exception.errorCode.AccountErrorCode;

public class AccountNotFoundException extends GlobalBusinessException {
    public static final AccountNotFoundException EXCEPTION = new AccountNotFoundException();

    public AccountNotFoundException() { super(AccountErrorCode.ACCOUNT_NOT_FOUND); }
}
