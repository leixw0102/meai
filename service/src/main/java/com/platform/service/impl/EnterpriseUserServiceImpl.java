package com.platform.service.impl;

import javax.annotation.Resource;

import com.platform.common.token.Token;
import com.platform.dao.EnterpriseUserDao;
import com.platform.domain.EnterpriseUser;
import com.platform.service.EnterpriseUserService;
import org.springframework.stereotype.Service;

/**
 * 用户
 * @author ehl
 *
 */
@Service
public class EnterpriseUserServiceImpl implements EnterpriseUserService {
	@Resource(name = "enterpriseUserDao")
	private EnterpriseUserDao enterpriseUserDao;
	@Override
	public EnterpriseUser registry(EnterpriseUser user) throws Exception {
//		if(!user.registryVerify()){
//			throw new Exception("资料填写不全");
//		}
		final String userkey = Token.getToken(user.getUserName(), "3");
		user.setUserKey(userkey);
		long id=(enterpriseUserDao).registry(user);
		if(id==0){
			throw new Exception("插入失败");
		}
		user.setUserId(id);
		return user;
	}

	@Override
	public EnterpriseUser login(EnterpriseUser user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkAlone(EnterpriseUser user) throws Exception {
		return enterpriseUserDao.isExistUser("select id from enterprise_user where user_name='"+user.getUserName()+"'");
	}

}
