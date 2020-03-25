package com.lzs.enums;

public enum ServiceErrCode {
    REQ_PARAM_ERR(1001,"请求参数异常"),
    NOTFINDE_RESULT_ERR(1004,"未找到结果");
    private int code;
    private String msg;

    ServiceErrCode(int code,String msg) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
