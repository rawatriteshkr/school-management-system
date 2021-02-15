package com.kipragno.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kipragno.tech.entites.Student;
import com.kipragno.tech.service.StudentService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/student/{registrationNo}")
	public ResponseEntity<Student> retreiveEmployeeById(@PathVariable Long registrationNo){
		Student student = studentService.retreiveStudentById(registrationNo);
		student.setPassword(null);
		return ResponseEntity.ok(student);
		
	}
}
