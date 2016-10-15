package com.platform.domain;

import com.google.common.base.Strings;

import java.io.Serializable;
import java.util.Date;

/**
 * 企业用户
 * 
 * 需要权限的时候在增加
 *TODO
 */
public class EnterpriseUser implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private Long userId;
	private String institutionCode; //机构代码
	private String introduction;//空间简介

	public EnterpriseUser() {
	}

	public EnterpriseUser(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	private String userKey;
	
	
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getInstitutionCode() {
		return institutionCode;
	}
	public void setInstitutionCode(String institutionCode) {
		this.institutionCode = institutionCode;
	}
	public String getEnterpriseName() {
		return enterpriseName;
	}
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	public Long getCurrentCity() {
		return currentCity;
	}
	public void setCurrentCity(Long currentCity) {
		this.currentCity = currentCity;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getCompanyMail() {
		return companyMail;
	}
	public void setCompanyMail(String companyMail) {
		this.companyMail = companyMail;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	private String enterpriseName;//企业名称
	
	private Long currentCity;
	private String contactName;
	
	private String companyMail;
	private String addressDetail;
//	private String 
	private Date time;
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	private String telphone;
	private String mark;

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "EnterpriseUser{" +
				"userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", userId=" + userId +
				", institutionCode='" + institutionCode + '\'' +
				", introduction='" + introduction + '\'' +
				", userKey='" + userKey + '\'' +
				", enterpriseName='" + enterpriseName + '\'' +
				", currentCity=" + currentCity +
				", contactName='" + contactName + '\'' +
				", companyMail='" + companyMail + '\'' +
				", addressDetail='" + addressDetail + '\'' +
				", time=" + time +
				", telphone='" + telphone + '\'' +
				", mark='" + mark + '\'' +
				'}';
	}

	/**
	 * 登陆验证
	 * @return
     */
	public boolean loginVerify(){
		return !Strings.isNullOrEmpty(getUserName()) && !Strings.isNullOrEmpty(getPassword());
	}

	/**
	 * 注册信息验证
	 * @return
	 */
	public boolean registryVerify(){
		return !Strings.isNullOrEmpty(getAddressDetail()) && !Strings.isNullOrEmpty(getCompanyMail())
				 && !Strings.isNullOrEmpty(getUserName())  && !Strings.isNullOrEmpty(getPassword()) 
				 && !Strings.isNullOrEmpty(getCompanyMail()) ;
	}
	
}
