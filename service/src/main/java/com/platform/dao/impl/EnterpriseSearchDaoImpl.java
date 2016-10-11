package com.platform.dao.impl;

import com.platform.bo.EnterpriseHomeSearchBo;
import com.platform.dao.EnterpriseSearchDao;
import com.platform.domain.EnterpriseUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by 雷晓武 on 2016/10/11.
 */
@Repository
public class EnterpriseSearchDaoImpl extends BaseDaoImpl implements EnterpriseSearchDao {
    public Logger logger = LoggerFactory.getLogger(getClass());
//    @Override
//    public List<EnterpriseUser> homeSearch(EnterpriseHomeSearchBo bo) throws Exception {
//        return  getBySqlRowMapper("select * from enterprise_user where ",new BeanPropertyRowMapper(EnterpriseUser.class));
//    }
    @Override
    public List<EnterpriseUser> search(String sql) throws Exception {
        return getBySqlRowMapper(sql,new BeanPropertyRowMapper(EnterpriseUser.class));
    }

    @Override
    public Long getTotalSize(String sql) throws Exception {
        logger.info("total sql = {}",sql);
        return getIdBySql(sql);
    }
}
