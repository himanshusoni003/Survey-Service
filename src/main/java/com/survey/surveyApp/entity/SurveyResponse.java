package com.survey.surveyApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class SurveyResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long surveyId; // This should be the primary key
    
    @ManyToOne
    private User respondent;
    
//    @OneToMany(mappedBy = "surveyResponse")
//    private List<Answer> answers;
//	
    
	
	public Long getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}
	public User getRespondent() {
		return respondent;
	}
	public void setRespondent(User respondent) {
		this.respondent = respondent;
	}
//	public List<Answer> getAnswers() {
//		return answers;
//	}
//	public void setAnswers(List<Answer> answers) {
//		this.answers = answers;
//	}
	
}
