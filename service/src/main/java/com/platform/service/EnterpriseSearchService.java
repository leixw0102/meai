package com.platform.service;

import com.platform.bo.EnterpriseHomeSearchBo;
import com.platform.common.response.ResponseBody;

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

}
