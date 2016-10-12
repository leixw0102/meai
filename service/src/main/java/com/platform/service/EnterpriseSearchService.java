package com.platform.service;

import com.platform.bo.EnterpriseHomeSearchBo;
import com.platform.common.response.ResponseBody;
import com.platform.domain.EnterpriseUser;

/**
 * Created by 雷晓武 on 2016/10/10.
 */
public interface EnterpriseSearchService {
    /**
     *
     * @param bo
     * @return
     * @throws Exception
     */
    public ResponseBody homeSearch(EnterpriseHomeSearchBo bo) throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public EnterpriseUser getEnterprise(Long id) throws Exception;

}
