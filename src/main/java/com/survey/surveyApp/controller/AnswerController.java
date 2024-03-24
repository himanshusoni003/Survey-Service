package com.survey.surveyApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.survey.surveyApp.entity.Answer;
import com.survey.surveyApp.service.AnswerService;

@RestController
@RequestMapping("/api/answer")
public class AnswerController {

	@Autowired
	private AnswerService answerService;
	@PostMapping("/submit")
	public void submitAnswer(@RequestBody Answer answer) {
		answerService.saveOrUpdateAnswer(answer);
	}
}
