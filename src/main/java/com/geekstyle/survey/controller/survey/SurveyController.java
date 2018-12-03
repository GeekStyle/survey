package com.geekstyle.survey.controller.survey;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geekstyle.survey.model.survey.Survey;
import com.geekstyle.survey.service.survey.SurveyService;

@RestController
@RequestMapping("/survey")
@Validated
public class SurveyController {
	
	@Autowired
	SurveyService surveyService;
	
	@PostMapping
	public ResponseEntity<?> insertSurvey(@RequestBody Survey survey) {
		surveyService.insertSurvey(survey);
		return ResponseEntity.status(HttpStatus.OK).body(survey);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> querySurveyById(@PathVariable Integer id) {
		Survey survey = surveyService.querySurveyById(id);
		return ResponseEntity.status(HttpStatus.OK).body(survey);
	}
	
	@GetMapping
	public ResponseEntity<?> querySurvey() {
		List<Survey> surveyList = surveyService.querySurvey();
		return ResponseEntity.status(HttpStatus.OK).body(surveyList);
	}
	
		
}
