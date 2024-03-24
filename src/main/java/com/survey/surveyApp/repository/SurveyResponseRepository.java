package com.survey.surveyApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.survey.surveyApp.entity.SurveyResponse;

public interface SurveyResponseRepository extends JpaRepository<SurveyResponse, Long> {
    List<SurveyResponse> findBySurveyId(Long surveyId);
}
