package com.platform.dao.impl;

import com.platform.dao.SpaceUserDao;
import com.platform.domain.SpaceUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 雷晓武 on 2016/10/10.
 */
@Repository
@Transactional(readOnly = true)
public class SpaceUserDaoImpl extends BaseDaoImpl implements SpaceUserDao{
    @Override
    public Long registry(SpaceUser user) throws Exception {
        return null;
    }

    @Override
    public SpaceUser login(SpaceUser user) throws Exception {
        return null;
    }

    @Override
    public boolean isExistUser(String sql) throws Exception {
        return false;
    }
}
