package com.survey.surveyApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.surveyApp.entity.Survey;
import com.survey.surveyApp.repository.SurveyRepository;

@Service
public class SurveyService {

	@Autowired
	private SurveyRepository surveyRepository;
	
	public Survey saveSurvey(Survey survey) {	
		return surveyRepository.save(survey);
	}
	
	public List<Survey> getAllSurveys() {
	    return surveyRepository.findAll();
	 }
	    
	public Survey updateSurvey(Survey survey) {
	    if (!surveyRepository.existsById(survey.getSurvey_id())) {
	       throw new IllegalArgumentException("Survey with id " + survey.getSurvey_id() + " does not exist");
	    }
	    return surveyRepository.save(survey);
	 }

	public List<Survey> findByAgeAndGender(int age, String gender){
		return surveyRepository.findByAgeAndGender(age, gender);
	}
}
