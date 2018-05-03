package com.geekstyle.survey.service.httpclient;

import org.springframework.util.MultiValueMap;

public interface RestHttpClient {
	
	/**
	 * 
	 * @param url
	 * @return
	 */
	public <T> T postForm(String url,MultiValueMap<String, String> formData,Class<T> responseType);
	
	public <T> T simpleGetData(String url,Class<T> responseType);
	
}
