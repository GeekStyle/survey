package com.geekstyle.survey.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.geekstyle.survey.model.user.Credential;
import com.geekstyle.survey.service.common.Constant;
import com.geekstyle.survey.service.user.CredentialService;
import com.geekstyle.survey.service.user.VerifyCodeService;

@RestController
@RequestMapping("/verifyCode")
public class VerifyCodeController implements Constant{
	
	@Autowired
	VerifyCodeService verifyCodeService;
	
	@Autowired
	CredentialService credentialService;
	
	@RequestMapping(value="/resetPassword",method=RequestMethod.POST,headers={"Accept=application/json"})
	public ResponseEntity<?> getVerifyCodeOfRestPassword(@RequestBody Credential credential) {
		//TODO
		//user input backend validation
		try{
			if(! credentialService.isExist(credential)) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(NOT_EXIST);
			}
			verifyCodeService.sendVerifyCode(credential.getUsername());
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
