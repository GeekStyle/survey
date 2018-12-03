package com.geekstyle.survey.service.httpclient.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.geekstyle.survey.service.httpclient.RestHttpClient;

@Service
public class RestHttpClientImpl implements RestHttpClient{
	
	@Override
	public <T> T postForm(String url,MultiValueMap<String, String> formData,Class<T> responseType) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(formData, headers);
		ResponseEntity<T> response = restTemplate.postForEntity(url, entity, responseType);
		T responseBody = response.getBody();
		return responseBody;
	}
	
	@Override
	public <T> T simpleGetData(String url,Class<T> responseType) {
		RestTemplate restTemplate = new RestTemplate();
		T t = restTemplate.getForObject(url, responseType);
		return t;
	}
	
}
