package com.kipragno.tech.entites;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "student_details")
public class Student {

	@Id
	@GenericGenerator(name = "registration_no", strategy = "com.kipragno.tech.generator.RegistrationNoGenerator")
	@GeneratedValue(generator = "registration_no") 
	@Column(name = "registration_no")
	private String registrationNo;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_birth", nullable = false)
	private Date dob;

	@Embedded
	private StudentFullName studentFullName;
	@Embedded
	private StudentCredentials studentCredentials;
	@Embedded
	private StudentContact studentContact;
	@Embedded
	private FeesDetails feesDetails;
	@Embedded
	private GuardianDetails guardianDetails;

	@OneToOne
	@JoinColumn(name = "contact_id")
	private GuardianContact guardianContact;

	@OneToOne
	@JoinColumn(name = "personal_detail_id")
	private StudentPersonalDetails studentPersonalDetails;

	@OneToOne
	@JoinColumn(name = "previous_detail_id")
	private StudentPreviousDetails studentPreviousDetails;

	public Student() {
		super();
	}

	public Student(String registrationNo, Date dob, StudentFullName studentFullName,
			StudentCredentials studentCredentials, StudentContact studentContact, FeesDetails feesDetails,
			GuardianDetails guardianDetails, GuardianContact guardianContact,
			StudentPersonalDetails studentPersonalDetails, StudentPreviousDetails studentPreviousDetails) {
		super();
		this.registrationNo = registrationNo;
		this.dob = dob;
		this.studentFullName = studentFullName;
		this.studentCredentials = studentCredentials;
		this.studentContact = studentContact;
		this.feesDetails = feesDetails;
		this.guardianDetails = guardianDetails;
		this.guardianContact = guardianContact;
		this.studentPersonalDetails = studentPersonalDetails;
		this.studentPreviousDetails = studentPreviousDetails;
	}

	public StudentPreviousDetails getStudentPreviousDetails() {
		return studentPreviousDetails;
	}

	public void setStudentPreviousDetails(StudentPreviousDetails studentPreviousDetails) {
		this.studentPreviousDetails = studentPreviousDetails;
	}

	public StudentPersonalDetails getStudentPersonalDetails() {
		return studentPersonalDetails;
	}

	public void setStudentPersonalDetails(StudentPersonalDetails studentPersonalDetails) {
		this.studentPersonalDetails = studentPersonalDetails;
	}

	public GuardianContact getGuardianContact() {
		return guardianContact;
	}

	public void setGuardianContact(GuardianContact guardianContact) {
		this.guardianContact = guardianContact;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public StudentFullName getStudentFullName() {
		return studentFullName;
	}

	public void setStudentFullName(StudentFullName studentFullName) {
		this.studentFullName = studentFullName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public StudentCredentials getStudentCredentials() {
		return studentCredentials;
	}

	public void setStudentCredentials(StudentCredentials studentCredentials) {
		this.studentCredentials = studentCredentials;
	}

	public StudentContact getStudentContact() {
		return studentContact;
	}

	public void setStudentContact(StudentContact studentContact) {
		this.studentContact = studentContact;
	}

	public FeesDetails getFeesDetails() {
		return feesDetails;
	}

	public void setFeesDetails(FeesDetails feesDetails) {
		this.feesDetails = feesDetails;
	}

	public GuardianDetails getGuardianDetails() {
		return guardianDetails;
	}

	public void setGuardianDetails(GuardianDetails guardianDetails) {
		this.guardianDetails = guardianDetails;
	}

}
