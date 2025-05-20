package org.example.domain.account.service;

import org.example.domain.account.model.Account;
import org.example.domain.user.model.User;

public interface CheckAccountService {

    void checkUserIsOwnerOfAccount(User user, Account account);
}
