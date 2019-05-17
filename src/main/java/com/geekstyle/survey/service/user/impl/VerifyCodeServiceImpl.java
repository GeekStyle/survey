package com.geekstyle.survey.service.user.impl;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekstyle.survey.dao.user.VerifyCodeDao;
import com.geekstyle.survey.model.user.VerifyCode;
import com.geekstyle.survey.service.user.CredentialService;
import com.geekstyle.survey.service.user.VerifyCodeService;
import com.geekstyle.survey.util.MailUtil;

@Service
public class VerifyCodeServiceImpl implements VerifyCodeService {
	
	@Autowired
	CredentialService credentialService;
	@Autowired
	VerifyCodeDao verifyCodeDao;

	@Override
	public void sendVerifyCode(String username) {
		String code = generateVerifyCode();
		VerifyCode verifyCode = new VerifyCode();
		verifyCode.setCode(code);
		verifyCode.setUsername(username);
		verifyCode.setCreateTime(new Date());
		verifyCodeDao.insertVerifyCode(verifyCode);
		MailUtil.sendRestPasswordEmail(code, username);
	}
	
	private String generateVerifyCode() {
		Random random = new Random();
		String code = "";
		for(int i=0;i<4;i++) {
			String digit = Integer.toString(random.nextInt(10));
			code += digit;
		}
		return code;
	}
	
	@Override
	public VerifyCode getVerifyCode(VerifyCode verifyCode) {
		return verifyCodeDao.getVerifyCode(verifyCode);
	}
}
