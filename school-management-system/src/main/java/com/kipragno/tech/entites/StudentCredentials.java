package com.kipragno.tech.entites;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StudentCredentials {

	@Column(name="email", nullable = false)
	private String email;
	@Column(name="username", nullable = false)
	private String username;
	@Column(name="password", nullable = false)
	private String password;
	@Column(name="confirm_password", nullable = false)
	private String confirmPassword;

	public StudentCredentials() {
		super();
	}

	public StudentCredentials(String email, String username, String password, String confirmPassword) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
