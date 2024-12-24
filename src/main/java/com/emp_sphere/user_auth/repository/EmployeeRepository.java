package com.emp_sphere.user_auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp_sphere.user_auth.model.EmployeeProfile;

public interface EmployeeRepository extends JpaRepository<EmployeeProfile,Long> {
	
	
		
}
