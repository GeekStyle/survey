package com.geekstyle.survey.service.survey;

import com.geekstyle.survey.model.survey.Survey;

public interface SurveyService {
	
	public Survey insertSurvey(Survey survey);
	
	public Survey querySurveyById(Integer id);
	
}
