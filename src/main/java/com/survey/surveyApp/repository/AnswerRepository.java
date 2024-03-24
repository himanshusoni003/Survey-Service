package com.survey.surveyApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.survey.surveyApp.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long>{

	public Answer findByUserIdAndQuestionId(Long userId, Long questionId);

}
