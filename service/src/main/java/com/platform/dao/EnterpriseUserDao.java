package com.platform.dao;


import com.platform.domain.EnterpriseUser;

public interface EnterpriseUserDao extends UserDao<EnterpriseUser>{
    public boolean updateEnterprise(String sql) throws Exception;
}
