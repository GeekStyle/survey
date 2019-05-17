package com.geekstyle.survey.service.user;

import com.geekstyle.survey.model.user.VerifyCode;

public interface VerifyCodeService {
	
	public void sendVerifyCode(String username);
	
	public VerifyCode getVerifyCode(VerifyCode verifyCode);
}
