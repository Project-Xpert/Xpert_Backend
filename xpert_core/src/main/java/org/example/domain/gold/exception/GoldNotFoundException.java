package org.example.domain.gold.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.gold.exception.errorCode.GoldErrorCode;

public class GoldNotFoundException extends GlobalBusinessException {
    public static final GoldNotFoundException EXCEPTION = new GoldNotFoundException();

    public GoldNotFoundException() {super(GoldErrorCode.GOLD_NOT_FOUND);}
}
