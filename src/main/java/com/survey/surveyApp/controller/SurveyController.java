package com.survey.surveyApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.survey.surveyApp.entity.Question;
import com.survey.surveyApp.entity.Survey;
import com.survey.surveyApp.service.SurveyService;

@RestController
@RequestMapping("/api/surveys")
public class SurveyController {
	
	@Autowired
	private SurveyService surveyService;
	
	@PostMapping("/create")
	public ResponseEntity<Survey> createSurvey(@RequestBody Survey survey) {
		for(Question question : survey.getQuestions()) {
			question.setSurvey(survey);
		}
		Survey savedSurvey = surveyService.saveSurvey(survey);
		return ResponseEntity.ok(savedSurvey);
	}
	
    @GetMapping("/all")
	public ResponseEntity<List<Survey>> getAllSurveys() {
    	List<Survey> surveys = surveyService.getAllSurveys();
	    return ResponseEntity.ok(surveys);
    }

    
    @PutMapping("/update")
    public ResponseEntity<Survey> updateSurvey(@RequestBody Survey survey) {
        // Add validation and error handling
        Survey updatedSurvey = surveyService.updateSurvey(survey);
        return ResponseEntity.ok(updatedSurvey);
    }

    @GetMapping("/getSurveyByAgeAndGender")
    public List<Survey> getSurveyBasedOnAgeAndGender(@RequestParam int age, @RequestParam String gender){
    	return surveyService.findByAgeAndGender(age, gender);
    }
}
