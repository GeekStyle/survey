package com.geekstyle.survey.controller.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.geekstyle.survey.model.survey.Survey;
import com.geekstyle.survey.service.survey.SurveyService;

@RestController
@RequestMapping("/survey")
public class SurveyController {
	
	@Autowired
	SurveyService serviceService;
	
	@RequestMapping(method=RequestMethod.POST)
	public void insertSurvey(@RequestBody Survey survey) {
		
		serviceService.insertSurvey(survey);
		
	}
	
}
