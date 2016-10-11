package com.platform.api.controller;


import com.alibaba.fastjson.JSONObject;
import com.platform.bo.EnterpriseHomeSearchBo;
import com.platform.common.response.ResponseBody;
import com.platform.common.response.ResponseConstantCode;
import com.platform.common.response.ResponseMsg;
import com.platform.service.EnterpriseSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 雷晓武 on 2016/10/10.
 */
@Controller
@RequestMapping("meai/1.0/enterprise")
public class EnterpriseHomeController extends BaseController {
    @Autowired
    private EnterpriseSearchService enterpriseSearchService;
    @RequestMapping("/search")
    @org.springframework.web.bind.annotation.ResponseBody
    public ResponseBody homeSearch(@RequestBody EnterpriseHomeSearchBo searchBo){

        //TODO
        try {
            return enterpriseSearchService.homeSearch(searchBo);
        } catch (Exception e) {
            e.printStackTrace();
            return 	new ResponseMsg(ResponseConstantCode.INTERNAL_ERROR_CODE,e.getMessage());
        }

    }

}
