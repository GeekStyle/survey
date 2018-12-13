package com.geekstyle.survey.model.survey;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class Survey {
	
	private Long id;
	@NotNull
	private String name;
	private Date createTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
