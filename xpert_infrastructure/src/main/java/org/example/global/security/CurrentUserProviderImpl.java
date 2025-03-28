package org.example.global.security;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.user.model.User;
import org.example.domain.user.service.GetUserService;
import org.example.global.security.auth.CustomUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrentUserProviderImpl implements CurrentUserProvider {
    private final GetUserService getUserService;

    @Override
    public String getCurrentUserId() {
        return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @Override
    public User getCurrentUser() {
        return getUserService.getUserByUserId(this.getCurrentUserId());
    }
}
