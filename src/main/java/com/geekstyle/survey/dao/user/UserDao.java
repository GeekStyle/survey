package com.geekstyle.survey.dao.user;

import com.geekstyle.survey.model.user.User;

public interface UserDao {
	
	public void insertUser(User user);
	
	public User getUserById(Integer id);
	
}