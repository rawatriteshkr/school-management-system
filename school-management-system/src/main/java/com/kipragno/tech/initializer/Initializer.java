package com.kipragno.tech.initializer;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
import com.kipragno.tech.repo.StudentAuthenticationRepoImpl;

@Component
@Transactional
public class Initializer implements CommandLineRunner {

	@Autowired
	private StudentAuthenticationRepoImpl studentAuthenticationRepoImpl;

	@Override
	public void run(String... args) throws Exception {
		
		Student s = new Student();
		StudentFullName studentFullName = new StudentFullName();
		studentFullName.setFirstName("Ritesh");
		studentFullName.setMiddleName("Kumar");
		studentFullName.setLastName("Rawat");
		
		StudentCredentials studentCredentials = new StudentCredentials();
		studentCredentials.setEmail("rkr@123");
		studentCredentials.setUsername("rkr@123");
		studentCredentials.setPassword("123");
		studentCredentials.setConfirmPassword("123");
		
		StudentContact studentContact = new StudentContact();
		studentContact.setGovernmentIdType("Aadhar");
		studentContact.setGovernmentIdNo("12345678");
		studentContact.setPhone(8976534590L);
		studentContact.setPic(null);
		
		FeesDetails feesDetails = new FeesDetails();
		feesDetails.setFeesPaid("yes");
		feesDetails.setReceiptNo("234567");
		
		GuardianDetails guardianDetails = new GuardianDetails();
		guardianDetails.setGuardianName("Manish");
		guardianDetails.setGuardianGovernmentIdType("Aadhar");
		guardianDetails.setGuardianGovernmentIdNo("23456785");
		guardianDetails.setPhone(234567890L);
		guardianDetails.setRelationship("Brother");
		guardianDetails.setOccupation("Developer");
		
		GuardianDetails guardianDetails2 = new GuardianDetails();
		guardianDetails2.setGuardianName("Manish");
		guardianDetails2.setGuardianGovernmentIdType("Aadhar");
		guardianDetails2.setGuardianGovernmentIdNo("23456785");
		guardianDetails2.setPhone(234567890L);
		guardianDetails2.setRelationship("Brother");
		guardianDetails2.setOccupation("Developer");
		
		GuardianContact guardianContact = new GuardianContact();
		guardianContact.setGuardianDetails(guardianDetails2);
		
		StudentAddress permanentAddress = new StudentAddress();
		permanentAddress.setAddress("Vinovapuri");
		permanentAddress.setCity("Sultanpur");
		permanentAddress.setState("UP");
		permanentAddress.setPincode(228001L);
		permanentAddress.setCountry("India");
		
		StudentAddress mailingAddress = new StudentAddress();
		mailingAddress.setAddress("charbagh");
		mailingAddress.setCity("lko");
		mailingAddress.setState("UP");
		mailingAddress.setPincode(228671L);
		mailingAddress.setCountry("India");
		
		guardianContact.setPermanentAddress(permanentAddress);
		guardianContact.setMailingAddress(mailingAddress);
		
		StudentPersonalDetails studentPersonalDetails = new StudentPersonalDetails();
		studentPersonalDetails.setBloodGroup("A");
		studentPersonalDetails.setDisability("NO");
		studentPersonalDetails.setDisabilityType(null);
		studentPersonalDetails.setHeight(5.7);
		studentPersonalDetails.setWeight(67.6);
		studentPersonalDetails.setLanguage_1("Java");
		studentPersonalDetails.setGender("male");
		studentPersonalDetails.setLanguage_2(null);
		studentPersonalDetails.setLanguage_3(null);
		studentPersonalDetails.setReligion("hindu");
		
		StudentPreviousDetails studentPreviousDetails = new StudentPreviousDetails();
		
		s.setStudentFullName(studentFullName);
		s.setDob(new Date());
		s.setStudentCredentials(studentCredentials);
		s.setStudentContact(studentContact);
		s.setFeesDetails(feesDetails);
		s.setGuardianDetails(guardianDetails);
		s.setGuardianContact(guardianContact);
		s.setStudentPersonalDetails(studentPersonalDetails);
		s.setStudentPreviousDetails(studentPreviousDetails);
		String t = studentAuthenticationRepoImpl.register(s);
		System.out.println(t);
	}

}
