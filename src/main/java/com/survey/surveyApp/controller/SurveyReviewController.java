package com.survey.surveyApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.survey.surveyApp.entity.SurveyResponse;
import com.survey.surveyApp.service.SurveyResponseService;

@RestController
@RequestMapping("/api/survey-reviews")
public class SurveyReviewController {
    @Autowired
    private SurveyResponseService surveyResponseService;
    
    @GetMapping("/{id}")
    public ResponseEntity<List<SurveyResponse>> getSurveyResponses(@PathVariable Long surveyId) {
        List<SurveyResponse> surveyResponses = surveyResponseService.getSurveyResponsesBySurveyId(surveyId);
        return ResponseEntity.ok(surveyResponses);
    }
}