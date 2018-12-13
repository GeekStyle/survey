package com.geekstyle.survey.model.user;

import java.util.Date;

public class Credential {
	private Integer id;
	private Integer userId;
	private String username;
	private String password;
	/**
	 * u:username e:email m:mobile number
	 */
	private String type;
	private Date createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Credential [id=" + id + ", userId=" + userId + ", username="
				+ username + ", password=" + password + ", type=" + type
				+ ", createTime=" + createTime + "]";
	}
	
}
