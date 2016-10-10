package com.platform.api.controller;

import java.io.IOException;
import java.net.HttpURLConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.platform.common.response.ResponseConstantCode;
import com.platform.common.response.ResponseMsg;
import com.platform.domain.EnterpriseUser;
import com.platform.service.EnterpriseUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/meai")
public class UserController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private EnterpriseUserService enterpriseUserService;
		
	

	@RequestMapping(value = "/enterprise/1.0/register")
	@ResponseBody
	public com.platform.common.response.ResponseBody meaiRegister(@RequestBody EnterpriseUser user) throws ServletException, IOException {
		try {
			logger.info(user.toString());
			if (!user.registryVerify()) {
				return new ResponseMsg(ResponseConstantCode.INVALID_PARAMETER_CODE, ResponseConstantCode.INVALID_PARAMETER_DESC);

			}

			if(!enterpriseUserService.checkAlone(user)){
				return 	new ResponseMsg(ResponseConstantCode.INTERNAL_ERROR_CODE,"用户已经存在");
			}

			EnterpriseUser userInfo = enterpriseUserService.registry(user) ;
			if (userInfo == null){
				return 	new ResponseMsg(ResponseConstantCode.INTERNAL_ERROR_CODE,"注册失败");
			}



			ResponseMsg message = new ResponseMsg(ResponseConstantCode.SUCCESS_CODE,ResponseConstantCode.SUCCESS_DESC);
			JSONObject info = new JSONObject();
			info.put("user_id",user.getUserId());
			info.put("access_token",user.getUserKey());
			message.setInfo(info);
			return message;
			//	logger.debug("影人图片查询结束，返回终端数据；");
		} catch (Exception e) {
			return 	new ResponseMsg(ResponseConstantCode.INTERNAL_ERROR_CODE,e.getMessage());
		}
	}
	@RequestMapping("/abc")
	@ResponseBody
	public com.platform.common.response.ResponseBody test(){
		return 	new ResponseMsg(ResponseConstantCode.INTERNAL_ERROR_CODE,"注册失败");
	}

}
