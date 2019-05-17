package com.geekstyle.survey.service.user.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekstyle.survey.dao.user.CredentialDao;
import com.geekstyle.survey.model.user.Credential;
import com.geekstyle.survey.model.user.VerifyCode;
import com.geekstyle.survey.service.common.Constant;
import com.geekstyle.survey.service.user.CredentialService;
import com.geekstyle.survey.service.user.VerifyCodeService;

@Service
public class CredentialServiceImpl implements CredentialService, Constant{
	
	@Autowired
	CredentialDao credentialDao;
	@Autowired
	VerifyCodeService verifyCodeService;
	
	@Override
	public Credential getCredential(String username) {
		return credentialDao.getCredentialByUserName(username);
	}

	@Override
	public void insertCredential(Credential credential) {
		credentialDao.insertCredential(credential);
	}

	@Override
	public boolean isExist(Credential credential) {
		int result = credentialDao.isExist(credential);
		if(result >= 1) {
			return true;
		}
		return false;
	}

	@Override
	public String resetPassword(Map<String, String> map) {
		VerifyCode verifyCodeQueryParam = new VerifyCode();
		verifyCodeQueryParam.setCode(map.get("code"));
		verifyCodeQueryParam.setUsername(map.get("username"));
		VerifyCode verifyCode = verifyCodeService.getVerifyCode(verifyCodeQueryParam);
		if(verifyCode == null) {
			return NOT_EXIST;
		}
		long isertTimeInMilliseconds = verifyCode.getCreateTime().getTime();
		long nowTimeInMilliSeconds = new Date().getTime();
		if(nowTimeInMilliSeconds - isertTimeInMilliseconds > 600000) {
			return EXPIRED;
		}
		Integer userId = credentialDao.getUserId(map.get("username"));
		Credential credential = new Credential();
		credential.setUserId(userId);
		credential.setPassword(map.get("newPassword"));
		credentialDao.updatePassword(credential);
		return SUCCESS;
	}

}
