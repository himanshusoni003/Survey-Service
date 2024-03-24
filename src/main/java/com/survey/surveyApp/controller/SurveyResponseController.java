package com.survey.surveyApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.survey.surveyApp.entity.SurveyResponse;
import com.survey.surveyApp.service.SurveyResponseService;

@RestController
@RequestMapping("/api/survey-responses")
public class SurveyResponseController {
    @Autowired
    private SurveyResponseService surveyResponseService;
    
    @PostMapping("/submit")
    public ResponseEntity<SurveyResponse> submitSurveyResponse(@RequestBody SurveyResponse surveyResponse) {
        SurveyResponse savedSurveyResponse = surveyResponseService.submitSurveyResponse(surveyResponse);
        return ResponseEntity.ok(savedSurveyResponse);
    }
}
