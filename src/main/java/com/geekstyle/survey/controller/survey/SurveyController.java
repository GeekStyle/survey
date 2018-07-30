package com.geekstyle.survey.controller.survey;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geekstyle.survey.model.survey.Student;
import com.geekstyle.survey.model.survey.Survey;
import com.geekstyle.survey.service.survey.SurveyService;

import io.swagger.annotations.ApiParam;

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
	
	@GetMapping("/{type}")
	@Valid
	public ResponseEntity<?> getStudentByType(
			@ApiParam(required = true, allowableValues = "A,C,C,D") @Pattern(regexp = "A|B|C|D") @PathVariable("type") String type) {
		return ResponseEntity.ok(null);
	}
	
	@PostMapping("/student")
	public ResponseEntity<?> addStudent(@Valid @RequestBody Student student, BindingResult bindingResult) {
//		if (ValidationUtil.hasErrors(bindingResult)) {
//			return ResponseEntity.status(400).body(ValidationUtil.formatErrorMessage(bindingResult));
//        }
		
		//studentService.addStudent(student);
		return ResponseEntity.ok(null);
	}
	
}
