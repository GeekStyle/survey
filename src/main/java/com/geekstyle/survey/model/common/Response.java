package com.geekstyle.survey.model.common;

public class Response {
	
	private String code;
	private Object data;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Response [code=" + code + ", data=" + data + "]";
	}
	
}
