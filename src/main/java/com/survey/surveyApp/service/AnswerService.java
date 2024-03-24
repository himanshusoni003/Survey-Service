package com.survey.surveyApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.surveyApp.entity.Answer;
import com.survey.surveyApp.repository.AnswerRepository;

//Assuming you have a service class for managing Answer entities
@Service
public class AnswerService {

 @Autowired
 private AnswerRepository answerRepository;

 public void saveOrUpdateAnswer(Answer answer) {
     // Check if an answer already exists for the given userId and questionId
     Answer existingAnswer = answerRepository.findByUserIdAndQuestionId(answer.getUserId(), answer.getQuestionId());
     if (existingAnswer != null) {
         // Handle case where an answer already exists
         // You may update the existing answer or reject the new submission
         // For example:
         // existingAnswer.setAnswerText(answer.getAnswerText());
         // answerRepository.save(existingAnswer);
         // Or throw an exception indicating that the user has already answered this question
         throw new IllegalStateException("User has already answered this question");
     } else {
         // No existing answer, save the new answer
         answerRepository.save(answer);
     }
 }
}
