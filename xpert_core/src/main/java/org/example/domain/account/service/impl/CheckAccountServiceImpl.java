package org.example.domain.account.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.account.exception.NotOwnerOfAccountException;
import org.example.domain.account.model.Account;
import org.example.domain.account.service.CheckAccountService;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckAccountServiceImpl implements CheckAccountService {

    @Override
    public void checkUserIsOwnerOfAccount(User user, Account account) {
        if (!user.getUserId().equals(account.getUser().getUserId())) {
            throw NotOwnerOfAccountException.EXCEPTION;
        }
    }
}
