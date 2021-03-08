package com.kipragno.tech.repo;

import org.springframework.security.core.userdetails.UserDetails;

import com.kipragno.tech.entites.Student;
import com.kipragno.tech.entites.StudentCredentials;

public interface StudentAuthenticationRepo {

	public String register(Student student);
	
	public UserDetails loadUserByUsername(String username);
	
	public boolean findStudentByEmail(String email);
	
	public boolean updatePassword(StudentCredentials studentCredentials);
}
