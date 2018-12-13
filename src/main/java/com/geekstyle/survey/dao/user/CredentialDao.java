package com.geekstyle.survey.dao.user;

import com.geekstyle.survey.model.user.Credential;

public interface CredentialDao {
	
	public void insertCredential(Credential credential);
	
	public Credential getCredentialByUserName(String username);
	
	public int isExist(Credential credential);
	
	public Integer getUserId(String username);
	
	public void updatePassword(Credential credential);
}

