package com.platform.service.impl;

import javax.annotation.Resource;

import com.platform.common.response.ResponseConstantCode;
import com.platform.common.response.ResponseMsg;
import com.platform.common.token.Token;
import com.platform.dao.EnterpriseUserDao;
import com.platform.domain.EnterpriseUser;
import com.platform.service.EnterpriseUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ExceptionDepthComparator;
import org.springframework.stereotype.Service;

/**
 * 用户
 * @author ehl
 *
 */
@Service
public class EnterpriseUserServiceImpl implements EnterpriseUserService {
    private Logger logger = LoggerFactory.getLogger(getClass());
	@Resource(name = "enterpriseUserDao")
	private EnterpriseUserDao enterpriseUserDao;
	@Override
	public EnterpriseUser registry(EnterpriseUser user) throws Exception {
//		if(!user.registryVerify()){
//			throw new Exception("资料填写不全");
//		}

		if(checkAlone(user)){
            logger.error("user exist...");

			 throw new Exception ("用户已经存在");
		}
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
		if(!user.loginVerify()){
			throw new Exception("用户名或密码为空");
		}

		long id=enterpriseUserDao.login(user);
        if(id>0){
            user.setUserId(id);
            return user;
        }

		throw new Exception("登录失败");
	}

	@Override
	public boolean checkAlone(EnterpriseUser user) throws Exception {
		return enterpriseUserDao.isExistUser("select id from enterprise_user where user_name='"+user.getUserName()+"'");
	}

    @Override
    public boolean logout(Long userId) throws Exception {
        return false;
    }

}
