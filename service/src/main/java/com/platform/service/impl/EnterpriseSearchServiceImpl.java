package com.platform.service.impl;

import com.platform.bo.EnterpriseHomeSearchBo;
import com.platform.common.response.Page;
import com.platform.common.response.ResponseBody;
import com.platform.dao.EnterpriseSearchDao;
import com.platform.domain.EnterpriseUser;
import com.platform.service.EnterpriseSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 雷晓武 on 2016/10/11.
 */
@Service
public class EnterpriseSearchServiceImpl implements EnterpriseSearchService {
    @Autowired
    private EnterpriseSearchDao enterpriseSearchDao;


    @Override
    public ResponseBody homeSearch(EnterpriseHomeSearchBo bo) throws Exception {
        //TODO bo check



        long total = enterpriseSearchDao.getTotalSize("select count(id) from enterprise_user "+ bo.whereSql());
        Page page = new Page(total, bo.getPageNumber(), bo.getPageSize()) {
            @Override
            protected String listAlias() {
                return "messages";
            }
        };
        List<EnterpriseUser> users = enterpriseSearchDao.search("select * from enterprise_user "+ bo.whereSql());
        page.setMessages(users);
        return page;
    }
}
