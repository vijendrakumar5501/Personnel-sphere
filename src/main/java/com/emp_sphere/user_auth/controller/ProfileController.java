package com.emp_sphere.user_auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emp_sphere.user_auth.model.Signup;
import com.emp_sphere.user_auth.model.TokenRequest;
import com.emp_sphere.user_auth.service.ProfileService;

@RestController
@RequestMapping("/signup")
public class ProfileController {

	@Autowired
	ProfileService empService;

	@PostMapping(" ")
	public ResponseEntity<?> UserSignup(@RequestBody Signup signupData) {
		try {

			Signup createdUser = empService.UserSignup(signupData);

			return ResponseEntity.status(HttpStatus.CREATED)
					.body("User registered successfully with Name: " + createdUser.getFullName());

		} catch (RuntimeException ex) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		} catch (Exception ex) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An unexpected error occurred: " + ex.getMessage());
		}

	}

	@PostMapping("/login")
	public ResponseEntity<?> postMethodName(@RequestBody Signup entity) {
		try {

//			Signup loginData = empService.UserLogin(entity.getEmail(), entity.getPasswordHash());
			
			 String token = empService.UserLogin(entity.getEmail(), entity.getPasswordHash());
	            return ResponseEntity.ok("Login successful. Token: " + token);

//			return ResponseEntity.status(HttpStatus.ACCEPTED).body("login succefully" + entity.getFullName());
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An unexpected error occurred: " + e.getMessage());

		}

	}
	
	@PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody TokenRequest tokenRequest) {
        try {
            String token = tokenRequest.getToken();
            // Perform logout logic here, e.g., invalidate the session or token
            empService.logout(token);

            return ResponseEntity.ok("Successfully logged out.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error occurred during logout: " + e.getMessage());
        }
    }
}


