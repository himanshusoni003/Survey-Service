package com.survey.surveyApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.survey.surveyApp.entity.User;
import com.survey.surveyApp.repository.UserRepository;
import com.survey.surveyApp.service.UserService;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@RequestBody User user) {
		
		Optional<User> existingUserOptional = userRepository.findByEmail(user.getEmail());
		
		if(existingUserOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("User with the provided email already exists");
		}
		
		
		User saveUser = userService.saveUser(user);
		return ResponseEntity.ok(saveUser);
	}
}
