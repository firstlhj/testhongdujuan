package com.lzs.exception;

import com.lzs.enums.ServiceErrCode;

public class BaseServiceException extends RuntimeException {
private  int code;

    public BaseServiceException(String message, ServiceErrCode serviceErrCode){
        super(message);
        this.code = serviceErrCode.getCode();
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
