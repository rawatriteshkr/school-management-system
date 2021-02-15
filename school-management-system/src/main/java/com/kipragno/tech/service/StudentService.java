package com.kipragno.tech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kipragno.tech.entites.Student;
import com.kipragno.tech.repo.StudentRepoImpl;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentRepoImpl studentRepo;

	public Student retreiveStudentById(Long registrationNo) {
		return studentRepo.retreiveStudentById(registrationNo);
	}
}
