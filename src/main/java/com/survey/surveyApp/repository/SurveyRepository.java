package com.survey.surveyApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.survey.surveyApp.entity.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
    List<Survey> findByAgeAndGender(int age, String gender);
}