package com.geekstyle.survey.controller.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> addSurvey(@RequestBody Survey survey) {
		surveyService.insertSurvey(survey);
		return ResponseEntity.status(HttpStatus.OK).body(survey);
	}
	
}
