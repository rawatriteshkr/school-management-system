package com.kipragno.tech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kipragno.tech.entites.Student;
import com.kipragno.tech.entites.StudentCredentials;
import com.kipragno.tech.repo.StudentAuthenticationRepoImpl;

@Service
@Transactional
public class StudentAuthenticationService implements UserDetailsService{

	@Autowired
	private StudentAuthenticationRepoImpl studentAuthenticationRepoImpl;
	
	public String register(Student student) {
		return studentAuthenticationRepoImpl.register(student);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return studentAuthenticationRepoImpl.loadUserByUsername(username);
	}

	public boolean findStudentByEmail(String email) {
		return studentAuthenticationRepoImpl.findStudentByEmail(email);
	}

	public boolean updatePassword(StudentCredentials studentCredentials) {
		return studentAuthenticationRepoImpl.updatePassword(studentCredentials);
	}
}
