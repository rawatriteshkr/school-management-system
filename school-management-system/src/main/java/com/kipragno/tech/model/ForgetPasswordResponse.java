package com.kipragno.tech.model;

public class ForgetPasswordResponse {

	private String otp;

	public ForgetPasswordResponse() {
		super();
	}

	public ForgetPasswordResponse(String otp) {
		super();
		this.otp = otp;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

}
