package com.geekstyle.survey.service.survey.impl;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekstyle.survey.dao.survey.SurveyDao;
import com.geekstyle.survey.model.survey.Survey;
import com.geekstyle.survey.service.httpclient.RestHttpClient;
import com.geekstyle.survey.service.survey.SurveyService;

@Service
public class SurveyServiceImpl implements SurveyService{

	@Autowired
	SurveyDao surveyDao;
	
	@Autowired
	RestHttpClient restHttpClient;

	@Override
	public Survey insertSurvey(Survey survey) {
		survey.setCreateTime(new Date());
		surveyDao.insertSurvey(survey);
		return survey;
	}

	@Override
	public Survey querySurveyById(Integer id) {
		return surveyDao.querySurvey(id);
	}
	
}
