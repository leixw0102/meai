package com.platform.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 雷晓武 on 2016/10/10.
 */
public class SpaceUser implements Serializable {

    private Long id;
    private String spaceName;
    private String institutionCode;
    private String operatingCompany;//运营公司
    private String currentCity;
    private String addressDetail;
    private String userName;
    private String password;
    private String telphone;
    private String mail;
    private String companyWebsite;
    private String companyWeibo;
    private Date createTime;
    private String authorities;

    private int current_role=0;
    private String introduction;//空间简介
    private String belongIndustry;//所属行业，用逗号分隔

    private String tags;//特殊标签
    private String logo_path;//
    private String weixin_path;
    private String pics_path;
    private String video_path;

    public String getCompanyWeibo() {
        return companyWeibo;
    }

    public void setCompanyWeibo(String companyWeibo) {
        this.companyWeibo = companyWeibo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public int getCurrent_role() {
        return current_role;
    }

    public void setCurrent_role(int current_role) {
        this.current_role = current_role;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getBelongIndustry() {
        return belongIndustry;
    }

    public void setBelongIndustry(String belongIndustry) {
        this.belongIndustry = belongIndustry;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getLogo_path() {
        return logo_path;
    }

    public void setLogo_path(String logo_path) {
        this.logo_path = logo_path;
    }

    public String getWeixin_path() {
        return weixin_path;
    }

    public void setWeixin_path(String weixin_path) {
        this.weixin_path = weixin_path;
    }

    public String getPics_path() {
        return pics_path;
    }

    public void setPics_path(String pics_path) {
        this.pics_path = pics_path;
    }

    public String getVideo_path() {
        return video_path;
    }

    public void setVideo_path(String video_path) {
        this.video_path = video_path;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    public String getInstitutionCode() {
        return institutionCode;
    }

    public void setInstitutionCode(String institutionCode) {
        this.institutionCode = institutionCode;
    }

    public String getOperatingCompany() {
        return operatingCompany;
    }

    public void setOperatingCompany(String operatingCompany) {
        this.operatingCompany = operatingCompany;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    @Override
    public String toString() {
        return "SpaceUser{" +
                "id=" + id +
                ", spaceName='" + spaceName + '\'' +
                ", institutionCode='" + institutionCode + '\'' +
                ", operatingCompany='" + operatingCompany + '\'' +
                ", currentCity='" + currentCity + '\'' +
                ", addressDetail='" + addressDetail + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", telphone='" + telphone + '\'' +
                ", mail='" + mail + '\'' +
                ", companyWebsite='" + companyWebsite + '\'' +
                ", companyWeibo='" + companyWeibo + '\'' +
                ", createTime=" + createTime +
                ", authorities='" + authorities + '\'' +
                ", current_role=" + current_role +
                ", introduction='" + introduction + '\'' +
                ", belongIndustry='" + belongIndustry + '\'' +
                ", tags='" + tags + '\'' +
                ", logo_path='" + logo_path + '\'' +
                ", weixin_path='" + weixin_path + '\'' +
                ", pics_path='" + pics_path + '\'' +
                ", video_path='" + video_path + '\'' +
                '}';
    }
}
