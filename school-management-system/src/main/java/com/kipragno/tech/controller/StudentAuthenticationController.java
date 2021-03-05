package com.kipragno.tech.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.MessagingException;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kipragno.tech.entites.FeesDetails;
import com.kipragno.tech.entites.GuardianContact;
import com.kipragno.tech.entites.GuardianDetails;
import com.kipragno.tech.entites.Student;
import com.kipragno.tech.entites.StudentAddress;
import com.kipragno.tech.entites.StudentContact;
import com.kipragno.tech.entites.StudentCredentials;
import com.kipragno.tech.entites.StudentFullName;
import com.kipragno.tech.entites.StudentPersonalDetails;
import com.kipragno.tech.entites.StudentPreviousDetails;
import com.kipragno.tech.generator.PasswordGenerator;
import com.kipragno.tech.mail.MailUtil;
import com.kipragno.tech.model.AuthenticationReponse;
import com.kipragno.tech.model.AuthenticationRequest;
import com.kipragno.tech.model.RegisterStudent;
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
	public ResponseEntity<?> register(@RequestBody RegisterStudent registerStudent) throws IOException {

		// Set Student values
		Student student = setStudentValues(registerStudent);
		String response = studentAuthenticationService.register(student);
		if (response != null && response.equals("409")) {
			return new ResponseEntity<>("Already Registered", HttpStatus.CONFLICT);
		} else if (response != null && response.equals("500")) {
			return new ResponseEntity<>("User not registered please try again", HttpStatus.INTERNAL_SERVER_ERROR);
		} else {

			/* Send regNo and otp
			 * try {
				MailUtil.sendMail("******@gmail.com", student.getRegistrationNo(),
						student.getStudentCredentials().getOtp());
			} catch (MessagingException e) {
				e.printStackTrace();
			}*/
			response = response + "\n" + "Registration No : " + student.getRegistrationNo() + "\n" + "Otp : "
					+ student.getStudentCredentials().getOtp();
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		}
	}

	@PostMapping(value = "/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {
		try {
			// Authenticate user
			authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		} catch (Exception e) {
			return new ResponseEntity<>("Incorrect username or password", HttpStatus.NOT_FOUND);
		}

		final UserDetails userDetails = studentAuthenticationService
				.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return new ResponseEntity<>(new AuthenticationReponse(jwt), HttpStatus.CREATED);
	}

	private Student setStudentValues(RegisterStudent registerStudent) {

		Student student = new Student();
		StudentFullName studentFullName = setStudentFullName(registerStudent);

		StudentCredentials studentCredentials = setStudentCredentials(registerStudent);

		StudentContact studentContact = setStudentContact(registerStudent);

		GuardianDetails guardianDetails = setGuardianDetails(registerStudent);

		FeesDetails feesDetails = setFeesDetails(registerStudent);

		GuardianDetails guardianDetails2 = setGuardian_2_Details(registerStudent);

		GuardianContact guardianContact = new GuardianContact();
		guardianContact.setGuardianDetails(guardianDetails2);

		StudentAddress permanentAddress = setPermanentAddress(registerStudent);

		StudentAddress mailingAddress = setMailingAddress(registerStudent);

		guardianContact.setPermanentAddress(permanentAddress);
		guardianContact.setMailingAddress(mailingAddress);

		StudentPersonalDetails studentPersonalDetails = setPersonalDetails(registerStudent);

		StudentPreviousDetails studentPreviousDetails = setPreviousDetails(registerStudent);

		student.setStudentFullName(studentFullName);
		
		try {
			Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(registerStudent.getDob());
			student.setDob(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		
		student.setStudentCredentials(studentCredentials);
		student.setStudentContact(studentContact);
		student.setFeesDetails(feesDetails);
		student.setGuardianDetails(guardianDetails);
		student.setGuardianContact(guardianContact);
		student.setStudentPersonalDetails(studentPersonalDetails);
		student.setStudentPreviousDetails(studentPreviousDetails);

		return student;
	}

	private StudentPreviousDetails setPreviousDetails(RegisterStudent registerStudent) {

		StudentPreviousDetails studentPreviousDetails = new StudentPreviousDetails();

		studentPreviousDetails.setPreviousSchool(registerStudent.getPreviousSchool());
		studentPreviousDetails.setClassName(registerStudent.getClassName());
		
		if ((registerStudent.getSection().equals("")) || (registerStudent.getSection().isEmpty())) {
			studentPreviousDetails.setSection("NA");
		} else {
			studentPreviousDetails.setSection(registerStudent.getSection());
		}
		
		studentPreviousDetails.setBoard(registerStudent.getBoard());
		studentPreviousDetails.setTc(registerStudent.getTc());
		studentPreviousDetails.setPercentage(registerStudent.getPercentage());
		studentPreviousDetails.setAcademicYear(registerStudent.getAcademicYear());

		return studentPreviousDetails;
	}

	private StudentPersonalDetails setPersonalDetails(RegisterStudent registerStudent) {

		StudentPersonalDetails studentPersonalDetails = new StudentPersonalDetails();

		if ((registerStudent.getBloodGroup().equals("")) || (registerStudent.getBloodGroup().isEmpty())) {
			studentPersonalDetails.setBloodGroup("NA");
		} else {
			studentPersonalDetails.setBloodGroup(registerStudent.getBloodGroup());
		}

		studentPersonalDetails.setDisability(registerStudent.getDisability());

		if ((registerStudent.getDisabilityType().equals("")) || (registerStudent.getDisabilityType().isEmpty())) {
			studentPersonalDetails.setDisabilityType("NA");
		} else {
			studentPersonalDetails.setDisabilityType(registerStudent.getDisabilityType());
		}
		if ((registerStudent.getHeight() == null)) {
			studentPersonalDetails.setHeight(0.0);
		} else {
			studentPersonalDetails.setHeight(registerStudent.getHeight());
		}
		if ((registerStudent.getWeight() == null)) {
			studentPersonalDetails.setWeight(0.0);
		} else {
			studentPersonalDetails.setWeight(registerStudent.getWeight());
		}

		studentPersonalDetails.setLanguage_1(registerStudent.getLanguage_1());

		if ((registerStudent.getLanguage_2().equals("")) || (registerStudent.getLanguage_2().isEmpty())) {
			studentPersonalDetails.setLanguage_2("NA");
		} else {
			studentPersonalDetails.setLanguage_2(registerStudent.getLanguage_2());
		}
		if ((registerStudent.getLanguage_3().equals("")) || (registerStudent.getLanguage_3().isEmpty())) {
			studentPersonalDetails.setLanguage_3("NA");
		} else {
			studentPersonalDetails.setLanguage_3(registerStudent.getLanguage_3());
		}
		if ((registerStudent.getReligion().equals("")) || (registerStudent.getReligion().isEmpty())) {
			studentPersonalDetails.setReligion("NA");
		} else {
			studentPersonalDetails.setReligion(registerStudent.getReligion());
		}

		studentPersonalDetails.setGender(registerStudent.getGender());

		return studentPersonalDetails;
	}

	private StudentAddress setMailingAddress(RegisterStudent registerStudent) {

		StudentAddress mailingAddress = new StudentAddress();

		if ((registerStudent.getMailingAddress().equals("")) || (registerStudent.getMailingAddress().isEmpty())) {
			mailingAddress.setAddress("NA");
		} else {
			mailingAddress.setAddress(registerStudent.getMailingAddress());
			mailingAddress.setCountry("India");
		}
		if ((registerStudent.getMailingCity().equals("")) || (registerStudent.getMailingCity().isEmpty())) {
			mailingAddress.setCity("NA");
		} else {
			mailingAddress.setCity(registerStudent.getMailingCity());
		}
		if ((registerStudent.getMailingState().equals("")) || (registerStudent.getMailingState().isEmpty())) {
			mailingAddress.setState("NA");
		} else {
			mailingAddress.setState(registerStudent.getMailingState());
		}
		if ((registerStudent.getMailingPincode() == null)) {
			mailingAddress.setPincode(0L);
		} else {
			mailingAddress.setPincode(registerStudent.getMailingPincode());
		}

		return mailingAddress;
	}

	private StudentAddress setPermanentAddress(RegisterStudent registerStudent) {
		
		StudentAddress permanentAddress = new StudentAddress();
		
		permanentAddress.setAddress(registerStudent.getPermanentAddress());
		permanentAddress.setCity(registerStudent.getPermanentCity());
		permanentAddress.setState(registerStudent.getPermanentState());
		permanentAddress.setPincode(registerStudent.getPermanentPincode());
		permanentAddress.setCountry("India");
		
		return permanentAddress;
	}

	private GuardianDetails setGuardian_2_Details(RegisterStudent registerStudent) {

		GuardianDetails guardianDetails2 = new GuardianDetails();

		if ((registerStudent.getGuardian_2_Name().equals("")) || (registerStudent.getGuardian_2_Name().isEmpty())) {
			guardianDetails2.setGuardianName("NA");
		} else {
			guardianDetails2.setGuardianName(registerStudent.getGuardian_2_Name());
		}
		if ((registerStudent.getGuardian_2_GovernmentIdType().equals(""))
				|| (registerStudent.getGuardian_2_GovernmentIdType().isEmpty())) {
			guardianDetails2.setGuardianGovernmentIdType("NA");
		} else {
			guardianDetails2.setGuardianGovernmentIdType(registerStudent.getGuardian_2_GovernmentIdType());
		}
		if ((registerStudent.getGuardian_2_GovernmentIdNo().equals(""))
				|| (registerStudent.getGuardian_2_GovernmentIdNo().isEmpty())) {
			guardianDetails2.setGuardianGovernmentIdNo("NA");
		} else {
			guardianDetails2.setGuardianGovernmentIdNo(registerStudent.getGuardian_2_GovernmentIdNo());
		}
		if ((registerStudent.getGuardian_2_Phone() == null)) {
			guardianDetails2.setPhone(0L);
		} else {
			guardianDetails2.setPhone(registerStudent.getGuardian_2_Phone());
		}
		if ((registerStudent.getGuardian_2_relationship().equals(""))
				|| (registerStudent.getGuardian_2_relationship().isEmpty())) {
			guardianDetails2.setRelationship("NA");
		} else {
			guardianDetails2.setRelationship(registerStudent.getGuardian_2_relationship());
		}
		if ((registerStudent.getGuardian_2_occupation().equals(""))
				|| (registerStudent.getGuardian_2_occupation().isEmpty())) {
			guardianDetails2.setOccupation("NA");
		} else {
			guardianDetails2.setOccupation(registerStudent.getGuardian_2_occupation());
		}

		return guardianDetails2;
	}

	private GuardianDetails setGuardianDetails(RegisterStudent registerStudent) {
		
		GuardianDetails guardianDetails = new GuardianDetails();
		guardianDetails.setGuardianName(registerStudent.getGuardianName());
		guardianDetails.setGuardianGovernmentIdType(registerStudent.getGuardianGovernmentIdType());
		guardianDetails.setGuardianGovernmentIdNo(registerStudent.getGuardianGovernmentIdNo());
		guardianDetails.setPhone(registerStudent.getGuardianPhone());
		guardianDetails.setRelationship(registerStudent.getRelationship());
		guardianDetails.setOccupation(registerStudent.getOccupation());
		
		return guardianDetails;
	}

	private FeesDetails setFeesDetails(RegisterStudent registerStudent) {
		
		FeesDetails feesDetails = new FeesDetails();
		feesDetails.setFeesPaid(registerStudent.getFeesPaid());
		feesDetails.setReceiptNo(registerStudent.getReceiptNo());
		return feesDetails;
	}

	private StudentContact setStudentContact(RegisterStudent registerStudent) {
		
		StudentContact studentContact = new StudentContact();
		studentContact.setGovernmentIdType(registerStudent.getGovernmentIdType());
		studentContact.setGovernmentIdNo(registerStudent.getGovernmentIdNo());
		studentContact.setPhone(Long.valueOf(registerStudent.getPhone()));
		studentContact.setPic(null);
		return studentContact;
	}

	private StudentCredentials setStudentCredentials(RegisterStudent registerStudent) {
		StudentCredentials studentCredentials = new StudentCredentials();
		studentCredentials.setEmail(registerStudent.getEmail());

		// Encrypt user password
		String otp = PasswordGenerator.generatePassword(8);
		String oneTimeEncryptedPassword = bcryptPasswordEncoder.encode(otp);
		studentCredentials.setPassword(oneTimeEncryptedPassword);
		studentCredentials.setConfirmPassword(oneTimeEncryptedPassword);
		studentCredentials.setRegistrationTime(new Date());
		studentCredentials.setPasswordChangeDate(new Date());
		studentCredentials.setOtp(otp);
		return studentCredentials;
	}

	private StudentFullName setStudentFullName(RegisterStudent registerStudent) {
		StudentFullName studentFullName = new StudentFullName();
		studentFullName.setFirstName(registerStudent.getFirstName());
		
		if ((registerStudent.getMiddleName().equals(""))
				|| (registerStudent.getMiddleName().isEmpty())) {
			studentFullName.setMiddleName("NA");
		} else {
			studentFullName.setMiddleName(registerStudent.getMiddleName());
		}
		
		studentFullName.setLastName(registerStudent.getLastName());
		return studentFullName;
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
