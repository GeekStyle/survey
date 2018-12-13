package com.geekstyle.survey.service.user;

import com.geekstyle.survey.model.user.User;

public interface UserService {
	
	public void createUser(User user);
	
	public void insertUser(User user);
	
	public User getUserById(Integer id);
	
}
