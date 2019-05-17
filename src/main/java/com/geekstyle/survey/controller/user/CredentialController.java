package com.geekstyle.survey.controller.user;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.geekstyle.survey.model.user.Credential;
import com.geekstyle.survey.model.user.User;
import com.geekstyle.survey.service.common.Constant;
import com.geekstyle.survey.service.user.CredentialService;
import com.geekstyle.survey.service.user.UserService;

@RestController
@RequestMapping("/credential")
public class CredentialController implements Constant{
	
	@Autowired
	CredentialService credentialService;
	@Autowired
	UserService userService;
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST,headers={"Accept=application/json"})
	public ResponseEntity<?> login(@RequestBody Credential credential) {
		//TODO
		//user input backend validation
		
		try{
			Credential credentialInDB = credentialService.getCredential(credential.getUsername());
			if(credentialInDB == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(NOT_EXIST);
			}else if(!credentialInDB.getPassword().equals(credential.getPassword())){
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(WRONG_PASSWORD);
			}else {
				User user = userService.getUserById(credentialInDB.getUserId());
				return ResponseEntity.status(HttpStatus.OK).body(user);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@RequestMapping(value="/isDuplicated",method=RequestMethod.POST,headers={"Accept=application/json"})
	public ResponseEntity<?> isDuplicated(@RequestBody Credential credential) {
		//TODO
		//user input backend validation
		
		try{
			boolean isDuplicated = credentialService.isExist(credential);
			return ResponseEntity.status(HttpStatus.OK).body(isDuplicated);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@RequestMapping(value="/resetPassword",method=RequestMethod.POST,headers={"Accept=application/json"})
	public ResponseEntity<?> resetPassword(@RequestBody Map<String,String> map) {
		//TODO
		//user input backend validation
		
		try{
			String result = credentialService.resetPassword(map);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());			
		}
	}
	
}
