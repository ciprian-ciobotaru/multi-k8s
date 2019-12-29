package com.demoapi.util;

import com.demoapi.util.ErrorType.MsgCodeEnum;
import com.demoapi.util.ErrorType.MsgScopeEnum;

public class ServiceException extends RuntimeException {

    private MsgCodeEnum error;
    private String errorMessage;
    private MsgScopeEnum scope;

    public ServiceException(MsgCodeEnum error, String errorMessage, MsgScopeEnum scope) {
        super(errorMessage);
        this.error = error;
        this.errorMessage = errorMessage;
        this.scope = scope;
    }

    public ServiceException(MsgCodeEnum error, String errorMessage) {
        super(errorMessage);
        this.error = error;
        this.errorMessage = errorMessage;
        this.scope = null;
    }

    public MsgCodeEnum getError() {
        return error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public MsgScopeEnum getScope() {
        return scope;
    }
}
