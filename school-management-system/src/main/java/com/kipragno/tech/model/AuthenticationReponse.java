package com.kipragno.tech.model;

public class AuthenticationReponse {

	private final String jwt;

	public AuthenticationReponse(String jwt) {
		super();
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}
	
}
