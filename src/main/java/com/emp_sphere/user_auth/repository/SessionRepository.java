package com.emp_sphere.user_auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp_sphere.user_auth.model.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {
	Session findByToken(String token);

}

