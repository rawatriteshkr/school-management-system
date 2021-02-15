package com.kipragno.tech.repo;

import org.springframework.security.core.userdetails.UserDetails;

import com.kipragno.tech.entites.Student;

public interface StudentAuthenticationRepo {

	public String register(Student student);
	
	public UserDetails loadUserByUsername(String username);
}
