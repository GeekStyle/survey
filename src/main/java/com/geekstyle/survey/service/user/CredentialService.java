package com.geekstyle.survey.service.user;

import java.util.Map;

import com.geekstyle.survey.model.user.Credential;

public interface CredentialService {
	
	public static final String CREDENTIAL_TYPE_NICKNAME = "N";
	public static final String CREDENTIAL_TYPE_EMAIL = "E";
	public static final String CREDENTIAL_TYPE_MOBILE = "M";
	
	public static final String CREDENTIAL_USERNAME_NOT_EXIST = "CREDENTIAL_USERNAME_NOT_EXIST";
	public static final String CREDENTIAL_PASSWORD_NOT_MATCH = "CREDENTIAL_PASSWORD_NOT_MATCH";
	public static final String CREDENTIAL_CORRECT = "CREDENTIAL_CORRECT";
	
	public void insertCredential(Credential credential);
	
	public Map<String,String> checkCredential(Credential credential);
	
	public boolean isExist(Credential credential);
	
	public String resetPassword(Map<String,String> map);
	
}
