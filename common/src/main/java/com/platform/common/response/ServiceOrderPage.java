package com.platform.common.response;

/**
 * Created by Administrator on 2016/6/12.
 */
public class ServiceOrderPage extends Page{
    private int user_id;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    private String status;
    @Override
    protected String listAlias() {
        return "messages";
    }
}
