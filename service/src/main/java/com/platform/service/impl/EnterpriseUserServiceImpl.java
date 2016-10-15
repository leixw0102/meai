package com.platform.service.impl;

import javax.annotation.Resource;

import com.platform.bo.EnterpriseEditMsg;
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

		EnterpriseUser eu=enterpriseUserDao.login(user);
        if(eu==null){
//            user.setUserId(id);
			throw new Exception("登录失败");
        }
		return eu;

	}

	@Override
	public boolean checkAlone(EnterpriseUser user) throws Exception {
		return enterpriseUserDao.isExistUser("select id from enterprise_user where user_name='"+user.getUserName()+"'");
	}

    @Override
    public boolean logout(Long userId) throws Exception {
        return false;
    }

	@Override
	public boolean updateBaseEdit(EnterpriseEditMsg msg) throws Exception {

		String sql = "update enterprise_user set pic_path='"+msg.getPicture_path()+"',introduction = '"+msg.getIntroduction()+"'," +
				"contact_name='"+msg.getContactName()+"', telphone='"+msg.getTelphone()+"', address_detail='"+msg.getCompanyAddress()+"' where id="+msg.getId();
		return enterpriseUserDao.updateEnterprise(sql);
	}
}
