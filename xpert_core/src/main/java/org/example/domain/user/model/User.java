package org.example.domain.user.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class User {

    private String userId;

    private String email;

    private String username;

    private String password;

    private String profile;

    private Long money;
}
