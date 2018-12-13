package com.geekstyle.survey.dao.user;

import com.geekstyle.survey.model.user.VerifyCode;

public interface VerifyCodeDao {

	public void insertVerifyCode(VerifyCode verifyCode);
	
	public VerifyCode getVerifyCode(VerifyCode verifyCode);
	
}
