package com.geekstyle.survey.service.survey.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekstyle.survey.dao.survey.SurveyDao;
import com.geekstyle.survey.model.survey.Survey;
import com.geekstyle.survey.service.survey.SurveyService;
import com.geekstyle.survey.util.UUIDUtil;

@Service
public class SurveyServiceImpl implements SurveyService{

	@Autowired
	SurveyDao surveyDao;

	@Override
	public void insertSurvey(Survey survey) {
		survey.setId(UUIDUtil.getUUID());
		surveyDao.insertSurvey(survey);
	}
}
