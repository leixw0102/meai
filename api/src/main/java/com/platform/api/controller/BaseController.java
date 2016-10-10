package com.platform.api.controller;



import com.alibaba.fastjson.JSONObject;
import com.platform.common.response.ResponseConstantCode;
import com.platform.common.response.ResponseMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class BaseController {


    public static final String ERROR_CODE = "errorCode";
    public static final String ERROR_DESC = "errorDesc";

    public static final String RESULT_CODE = "resultCode";
    public static final String RESULT_DESC = "resultDesc";

    protected void loggeRequestrMsg(String url,String info){
        logger.debug("url={},request info = {}",url,info);
    }
    protected SimpleDateFormat sdf1 = new SimpleDateFormat("yyMMdd");
    public JSONObject getSuccessJsonObject(){
        JSONObject object = new JSONObject();
        object.put("code",1000);
        object.put("msg","success");
        return object;
    }

    protected SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public JSONObject getSuccessListJsons(Long total,List list){
        JSONObject object = new JSONObject();
        object.put("code",1000);
        object.put("msg","success");
        object.put("total", total);
        object.put("list", list);
        return object;
    }

    public JSONObject getFailedJsonObject(int errorCode, String error){
        JSONObject object = new JSONObject();
        object.put("code",errorCode);
        object.put("msg",error);
        return object;
    }



    protected final static Logger logger = LoggerFactory.getLogger(BaseController.class);
    

    protected ResponseMsg getSuccess(){
        return new ResponseMsg(ResponseConstantCode.SUCCESS_CODE,ResponseConstantCode.SUCCESS_DESC);
    }
}
