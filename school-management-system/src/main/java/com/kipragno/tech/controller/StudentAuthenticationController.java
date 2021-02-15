package com.kipragno.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kipragno.tech.entites.Student;
import com.kipragno.tech.model.AuthenticationReponse;
import com.kipragno.tech.model.AuthenticationRequest;
import com.kipragno.tech.service.StudentAuthenticationService;
import com.kipragno.tech.util.JwtUtil;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class StudentAuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Autowired
	private StudentAuthenticationService studentAuthenticationService;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody Student student) {
		// Encrypt user password
		student.setPassword(bcryptPasswordEncoder.encode(student.getPassword()));
		String response = studentAuthenticationService.register(student);
		if(response != null && response.equals("409")) {
			return new ResponseEntity<>("Already Registered", HttpStatus.CONFLICT);
		}else if(response != null && response.equals("500")) {
			return new ResponseEntity<>("User not registered please try again", HttpStatus.INTERNAL_SERVER_ERROR);
		}else {
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		}
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {
		try {
			//Authenticate user
			authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		}catch(Exception e) {
			return new ResponseEntity<>("Incorrect username or password", HttpStatus.NOT_FOUND);
		}
		
		final UserDetails userDetails = studentAuthenticationService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		return new ResponseEntity<>(new AuthenticationReponse(jwt),  HttpStatus.CREATED);
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("BAD_CREDENTIAL", e);
		}
	}
}
