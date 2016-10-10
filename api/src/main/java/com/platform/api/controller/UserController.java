package com.platform.api.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import com.platform.common.response.ResponseConstantCode;
import com.platform.common.response.ResponseMsg;
import com.platform.domain.EnterpriseUser;
import com.platform.service.EnterpriseUserService;
import com.sun.tools.javac.comp.Enter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSONObject;


@Controller
@RequestMapping("/meai")
public class UserController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private EnterpriseUserService enterpriseUserService;
		
	

	@RequestMapping(value = "/1.0/enterprise/register")
	@ResponseBody
	public com.platform.common.response.ResponseBody meaiRegister(@RequestBody EnterpriseUser user) throws ServletException, IOException {
		try {
			logger.info(user.toString());
			if (!user.registryVerify()) {
				return new ResponseMsg(ResponseConstantCode.INVALID_PARAMETER_CODE, ResponseConstantCode.INVALID_PARAMETER_DESC);

			}


			EnterpriseUser userInfo = enterpriseUserService.registry(user) ;
			if (userInfo == null){
				return 	new ResponseMsg(ResponseConstantCode.INTERNAL_ERROR_CODE,"注册失败");
			}



			ResponseMsg message = getSuccess();
			JSONObject info = new JSONObject();
			info.put("user_id",user.getUserId());
//			info.put("access_token",user.getUserKey());
			message.setInfo(info);
			return message;
			//	logger.debug("影人图片查询结束，返回终端数据；");
		} catch (Exception e) {
			e.printStackTrace();
			return 	new ResponseMsg(ResponseConstantCode.INTERNAL_ERROR_CODE,e.getMessage());
		}
	}
	@RequestMapping("/abc")
	@ResponseBody
	public com.platform.common.response.ResponseBody test(){
		return 	new ResponseMsg(ResponseConstantCode.INTERNAL_ERROR_CODE,"注册失败");
	}
	@RequestMapping(value = "/1.0/enterprise/login")
	@ResponseBody
	public com.platform.common.response.ResponseBody enterpriseLogin(@RequestBody EnterpriseUser user){
		logger.info("enterprise login :parameters uName={},password={}",user.getUserName(),user.getPassword());

		try {
			EnterpriseUser login=enterpriseUserService.login(user);

			if(null == login){
				return 	new ResponseMsg(ResponseConstantCode.INTERNAL_ERROR_CODE,"用户名或密码正确，请确认你已经注册");
			}
			ResponseMsg success = getSuccess();
			JSONObject info = new JSONObject();
			info.put("userId",login.getUserId());
			success.setInfo(info);
			return success;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("logion failed {}",e.getLocalizedMessage());
			return 	new ResponseMsg(ResponseConstantCode.INTERNAL_ERROR_CODE,e.getMessage());
		}

	}
	@RequestMapping(value = "/1.0/enterprise/logout/{userId}")
	public @ResponseBody com.platform.common.response.ResponseBody logout(@PathVariable Long userId){
		try {
			if(enterpriseUserService.logout(userId)){
				return getSuccess();
			};
//			return new ResponseMsg<>()
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
