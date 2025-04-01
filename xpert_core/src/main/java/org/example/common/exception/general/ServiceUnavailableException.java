package org.example.common.exception.general;

import org.example.common.exception.GlobalBusinessException;

public class ServiceUnavailableException extends GlobalBusinessException {

    public static final ServiceUnavailableException EXCEPTION = new ServiceUnavailableException();

    public ServiceUnavailableException() { super(GeneralExceptionCode.SERVICE_TEMPORARILY_UNAVAILABLE); }
}
