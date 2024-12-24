package com.emp_sphere.user_auth.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sessions")
public class Session {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "session_id")
	private Long sessionId;

	@Column(name = "user_id", nullable = false)
	private Long userId; // Store the user ID directly

	@Column(name = "token", nullable = false, length = 512)
	private String token;

	@Column(name = "created_at", nullable = false)
	private Timestamp createdAt;

	@Column(name = "expires_at", nullable = false)
	private Timestamp expiresAt;

	@Column(name = "is_valid", nullable = false)
	private Boolean isValid;

	// Constructors
	public Session() {
	}

	public Session(Long userId, String token, Timestamp createdAt, Timestamp expiresAt, Boolean isValid) {
		this.userId = userId;
		this.token = token;
		this.createdAt = createdAt;
		this.expiresAt = expiresAt;
		this.isValid = isValid;
	}

	// Getters and Setters
	public Long getSessionId() {
		return sessionId;
	}

	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Timestamp expiresAt) {
		this.expiresAt = expiresAt;
	}

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	// toString() for debugging
	@Override
	public String toString() {
		return "Session{" + "sessionId=" + sessionId + ", userId=" + userId + ", token='" + token + '\''
				+ ", createdAt=" + createdAt + ", expiresAt=" + expiresAt + ", isValid=" + isValid + '}';
	}
}
