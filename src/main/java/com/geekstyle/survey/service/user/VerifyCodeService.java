package com.geekstyle.survey.service.user;

import com.geekstyle.survey.model.user.Credential;
import com.geekstyle.survey.model.user.VerifyCode;

public interface VerifyCodeService {
	
	public String sendVerifyCode(Credential credential);
	
	public VerifyCode getVerifyCode(VerifyCode verifyCode);
}
