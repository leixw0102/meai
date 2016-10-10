package com.platform.common.exception;

/**
 * Created by bright on 16-6-5.
 */
public class ApiException extends RuntimeException{
    private String code;
    private Object responseMsg;
    public ApiException(String code,Object responseMsg) {
        this.code = code;
        this.responseMsg=responseMsg;
    }

    public Object getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(Object responseMsg) {
        this.responseMsg = responseMsg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
