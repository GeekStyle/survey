package com.geekstyle.survey.controller.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geekstyle.survey.model.survey.Survey;
import com.geekstyle.survey.service.survey.SurveyService;

@RestController
@RequestMapping("/survey")
public class SurveyController {
	
	@Autowired
	SurveyService surveyService;
	
	@PostMapping
	public Survey insertSurvey(@RequestBody Survey survey) {
		return surveyService.insertSurvey(survey);
	}
	
}
