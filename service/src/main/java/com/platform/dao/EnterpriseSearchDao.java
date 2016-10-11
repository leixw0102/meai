package com.platform.dao;

import com.platform.bo.EnterpriseHomeSearchBo;
import com.platform.domain.EnterpriseUser;

import java.util.List;

/**
 * Created by 雷晓武 on 2016/10/11.
 */
public interface EnterpriseSearchDao{

    public List<EnterpriseUser> search(String sql) throws Exception;

    public Long getTotalSize(String sql) throws Exception;
}
