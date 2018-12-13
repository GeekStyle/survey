package com.geekstyle.survey.controller.user;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geekstyle.survey.model.common.Response;
import com.geekstyle.survey.model.user.Credential;
import com.geekstyle.survey.service.user.CredentialService;
import com.geekstyle.survey.service.user.UserService;

@Controller
@RequestMapping("/credential")
public class CredentialController {
	
	@Autowired
	CredentialService credentialService;
	@Autowired
	UserService userService;
	
	
	@RequestMapping(value="/check",method=RequestMethod.POST,headers={"Accept=application/json"})
	public @ResponseBody Response login(@RequestBody Credential credential) {
		Response response = new Response();
		//TODO
		//user input backend validation
		
		try{
			Map<String,String> credentialCheckResult = credentialService.checkCredential(credential);
			response.setCode(credentialCheckResult.get("credentialResult"));
			if(credentialCheckResult.get("credentialResult").equals(CredentialService.CREDENTIAL_CORRECT)) {
				Integer userId = Integer.parseInt(credentialCheckResult.get("userId"));
				response.setData(userService.getUserById(userId));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	@RequestMapping(value="/isDuplicated",method=RequestMethod.POST,headers={"Accept=application/json"})
	public @ResponseBody Response isDuplicated(@RequestBody Credential credential) {
		Response response = new Response();
		//TODO
		//user input backend validation
		
		try{
			boolean isDuplicated = credentialService.isExist(credential);
			response.setCode(String.valueOf(isDuplicated));
		}catch(Exception e) {
			e.printStackTrace();
			//TOTO
			//exception handle
			
		}
		
		//封装
		response.setData(null);
		return response;
	}
	
	@RequestMapping(value="/resetPassword",method=RequestMethod.POST,headers={"Accept=application/json"})
	public @ResponseBody Response resetPassword(@RequestBody Map<String,String> map) {
		Response response = new Response();
		//TODO
		//user input backend validation
		
		try{
			response.setCode(credentialService.resetPassword(map));
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
