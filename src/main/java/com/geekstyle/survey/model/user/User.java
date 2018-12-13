package com.geekstyle.survey.model.user;

import java.util.Date;

public class User {
	private Integer id;
	private String nickname;
	private String email;
	private String mobile;
	private String password;
	private String gender;
	private Date birthday;
	private Date createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", nickname=" + nickname + ", email=" + email
				+ ", mobile=" + mobile + ", password=" + password + ", gender="
				+ gender + ", birthday=" + birthday + ", createTime="
				+ createTime + "]";
	}
	
}	
