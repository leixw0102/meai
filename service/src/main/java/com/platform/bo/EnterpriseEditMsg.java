package com.platform.bo;

import com.google.common.base.Strings;

/**
 * Created by 雷晓武 on 2016/10/12.
 */
public class EnterpriseEditMsg {
    private Long id;
   private String picture_path;
    private String introduction;
    private String contactName;
    private String telphone;
    private String companyAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPicture_path() {
        return picture_path;
    }

    public void setPicture_path(String picture_path) {
        this.picture_path = picture_path;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public boolean verifyNull(){
        return Strings.isNullOrEmpty(getCompanyAddress()) || Strings.isNullOrEmpty(getContactName())
                ||Strings.isNullOrEmpty(getIntroduction()) || Strings.isNullOrEmpty(getPicture_path())
                ||Strings.isNullOrEmpty(getTelphone())||getId()==0;
    }

    @Override
    public String toString() {
        return "EnterpriseEditMsg{" +
                "id=" + id +
                ", picture_path='" + picture_path + '\'' +
                ", introduction='" + introduction + '\'' +
                ", contactName='" + contactName + '\'' +
                ", telphone='" + telphone + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                '}';
    }
}
