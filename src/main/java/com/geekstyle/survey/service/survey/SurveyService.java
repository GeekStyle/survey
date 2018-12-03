package com.geekstyle.survey.service.survey;

import java.util.List;

import com.geekstyle.survey.model.survey.Survey;

public interface SurveyService {
	
	public Survey insertSurvey(Survey survey);
	
	public Survey querySurveyById(Integer id);
	
	public List<Survey> querySurvey();
	
}
