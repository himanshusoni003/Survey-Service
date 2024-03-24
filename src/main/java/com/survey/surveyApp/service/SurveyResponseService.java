package com.survey.surveyApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.surveyApp.entity.SurveyResponse;
import com.survey.surveyApp.repository.SurveyResponseRepository;

@Service
public class SurveyResponseService {
    @Autowired
    private SurveyResponseRepository surveyResponseRepository;
    
    public SurveyResponse submitSurveyResponse(SurveyResponse surveyResponse) {
        return surveyResponseRepository.save(surveyResponse);
    }
    
    public List<SurveyResponse> getSurveyResponsesBySurveyId(Long surveyId) {
        return surveyResponseRepository.findBySurveyId(surveyId);
    }
}