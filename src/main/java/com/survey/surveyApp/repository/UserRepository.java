package com.survey.surveyApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.survey.surveyApp.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByEmail(String email);
}
