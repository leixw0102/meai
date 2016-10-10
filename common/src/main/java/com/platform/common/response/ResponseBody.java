package com.platform.common.response;

import com.alibaba.fastjson.serializer.NameFilter;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xiaowu lei
 * Date: 13-12-27
 * Time: 上午11:32
 */
public abstract  class ResponseBody {
    protected ResponseBody(String code, String message) {
        this.code = code;
        this.message = message;
    }

    protected ResponseBody() {
        this(ResponseConstantCode.SUCCESS_CODE,ResponseConstantCode.SUCCESS_DESC);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String code;
    private String message;
    public  abstract List<NameFilter> nameFilters();
}