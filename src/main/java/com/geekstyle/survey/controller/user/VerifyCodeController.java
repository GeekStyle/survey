package com.geekstyle.survey.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geekstyle.survey.model.common.Response;
import com.geekstyle.survey.model.user.Credential;
import com.geekstyle.survey.service.user.VerifyCodeService;

@Controller
@RequestMapping("/verifyCode")
public class VerifyCodeController {
	
	@Autowired
	VerifyCodeService verifyCodeService;
	
	@RequestMapping(value="/resetPassword",method=RequestMethod.POST,headers={"Accept=application/json"})
	public @ResponseBody Response getVerifyCodeOfRestPassword(@RequestBody Credential credential) {
		//TODO
		//user input backend validation
		Response response = new Response();
		try{
			response.setCode(verifyCodeService.sendVerifyCode(credential));
		}catch(Exception e) {
			e.printStackTrace();
			//TOTO
			//exception handle
		}
		//封装
		response.setData(null);
		return response;
	}
}
