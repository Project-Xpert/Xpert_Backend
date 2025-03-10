package org.example.domain.user.service;

public interface CheckUserService {

    void checkUserAlreadyExistsByUserId(String userId);

    void checkUserAlreadyExistsByEmail(String email);
}
