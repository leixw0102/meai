package com.platform.service;


import com.platform.bo.EnterpriseEditMsg;
import com.platform.domain.EnterpriseUser;

public interface EnterpriseUserService extends UserService<EnterpriseUser> {

    public boolean updateBaseEdit(EnterpriseEditMsg msg) throws Exception;
	
}
