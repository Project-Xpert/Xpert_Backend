package org.example.domain.fx.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.domain.user.model.User;

@Setter
@Getter
@Builder
public class Fx {

    private FXType fxType;

    private User user;

    private int amount;

    private int sumOfBuy;
}
