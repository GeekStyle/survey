package com.geekstyle.survey.dao.survey;

import com.geekstyle.survey.model.survey.Survey;

public interface SurveyDao {
	
	public void insertSurvey(Survey survey);
	
	public Survey querySurveyById(Integer id);
	
}
