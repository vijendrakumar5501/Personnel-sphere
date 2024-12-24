package com.emp_sphere.user_auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp_sphere.user_auth.model.Signup;

public interface ProfileRepository extends JpaRepository<Signup, Long> {

	Optional<Signup> findByEmail(String email);
	
	
	
	
	
}
