package com.kipragno.tech.entites;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "student_credentials")
public class StudentCredentials {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "credential_id")
	private Long credentialId;
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "confirm_password", nullable = false)
	private String confirmPassword;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "registration_time", nullable = false)
	private Date registrationTime;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "password_change_date", nullable = false)
	private Date passwordChangeDate;
	@Transient
	private String otp;

	public StudentCredentials() {
		super();
	}

	

	public StudentCredentials(Long credentialId, String email, String password, String confirmPassword,
			Date registrationTime, Date passwordChangeDate, String otp) {
		super();
		this.credentialId = credentialId;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.registrationTime = registrationTime;
		this.passwordChangeDate = passwordChangeDate;
		this.otp = otp;
	}



	public String getOtp() {
		return otp;
	}



	public void setOtp(String otp) {
		this.otp = otp;
	}



	public Date getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(Date registrationTime) {
		this.registrationTime = registrationTime;
	}

	public Date getPasswordChangeDate() {
		return passwordChangeDate;
	}

	public void setPasswordChangeDate(Date passwordChangeDate) {
		this.passwordChangeDate = passwordChangeDate;
	}

	public Long getCredentialId() {
		return credentialId;
	}

	public void setCredentialId(Long credentialId) {
		this.credentialId = credentialId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
