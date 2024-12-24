package com.emp_sphere.user_auth.service;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.emp_sphere.user_auth.model.EmployeeProfile;
import com.emp_sphere.user_auth.model.Session;
import com.emp_sphere.user_auth.model.Signup;

import com.emp_sphere.user_auth.repository.EmployeeRepository;
import com.emp_sphere.user_auth.repository.ProfileRepository;
import com.emp_sphere.user_auth.repository.SessionRepository;
import com.emp_sphere.user_auth.util.JwtUtil;

@Service
public class ProfileService {

	@Autowired
	ProfileRepository profileRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	JwtUtil jwtUtil;

	@Autowired
	SessionRepository sessionRepository;

	public Signup UserSignup(@RequestBody Signup userSignup) {
		try {
			if (profileRepository.findByEmail(userSignup.getEmail()).isPresent()) {
				throw new RuntimeException("this email is already registered ");
			}

			Signup newUser = new Signup();

			newUser.setFullName(userSignup.getFullName());
			newUser.setEmail(userSignup.getEmail());
			newUser.setPhone(userSignup.getPhone());
			newUser.setPasswordHash(userSignup.getPasswordHash());
			newUser.setCreatedAt(new Timestamp(System.currentTimeMillis()));
			newUser.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
			newUser.setIsActive(true);

			// for getting userId
			Signup saveProfile = profileRepository.save(newUser);

			EmployeeProfile emp = new EmployeeProfile();

			// updated employeeprofile model
			emp.setFullname(saveProfile.getFullName());
			emp.setUserId(saveProfile.getLoginId().intValue());
			emp.setUpdatedOn(new Timestamp(System.currentTimeMillis()));

			employeeRepository.save(emp);

			return saveProfile;

		} catch (Exception e) {
			throw new RuntimeException("error occured during signup" + e.getMessage());
		}
	}

	public String UserLogin(String email, String currPassword) {
		try {
			Optional<Signup> userDb = profileRepository.findByEmail(email);

			if (userDb.isEmpty()) {
				throw new RuntimeException("User not found");
			}
			Signup user = userDb.get();
			if (!user.getPasswordHash().equals(currPassword)) {
				throw new RuntimeException("invalid email or password");
			}
			String token = jwtUtil.generateToken(user.getEmail(),user.getLoginId());

			Timestamp createdAt = new Timestamp(System.currentTimeMillis());
			Timestamp expiresAt = new Timestamp(System.currentTimeMillis() + 1000 * 60 * 60 * 10); // 10 hours

			Session session = new Session(user.getLoginId(), token, createdAt, expiresAt, true);
			sessionRepository.save(session);

			return token;

		} catch (Exception e) {
			throw new RuntimeException("error occured du to" + e.getMessage());
		}

	}
	
	public void logout(String token) {
        // Invalidate session based on token
        Session session = sessionRepository.findByToken(token);
        if (session != null) {
            session.setIsValid(false);  // Mark the session as invalid
            sessionRepository.save(session);  
        } else {
            throw new RuntimeException("Session not found for the provided token.");
        }
    }
	
	
	
	
	
    
}

