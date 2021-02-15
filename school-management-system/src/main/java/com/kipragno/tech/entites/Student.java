package com.kipragno.tech.entites;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long registrationNo;
	@Column
	private String firstName;
	@Column
	private String middleName;
	@Column
	private String lastName;
	@Column
	private String motherName;
	@Column
	private String fatherName;
	@Column
	private String gaurdianName;
	@Column
	private String emailId;
	@Column
	private String contact;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address permanentAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address mailingAddress;
	
	@Column
	private String previousSchool;
	@Column
	private String currentClass;
	@Column
	private String password;
	@Column
	private String dob;
	@Column
	private String gender;

	public Student() {

	}

	public Student(Long registrationNo, String firstName, String middleName, String lastName, String motherName, String fatherName,
			String gaurdianName, String emailId, String contact, Address permanentAddress, Address mailingAddress,
			String previousSchool, String currentClass, String password, String dob, String gender) {
		super();
		this.registrationNo = registrationNo;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.motherName = motherName;
		this.fatherName = fatherName;
		this.gaurdianName = gaurdianName;
		this.emailId = emailId;
		this.contact = contact;
		this.permanentAddress = permanentAddress;
		this.mailingAddress = mailingAddress;
		this.previousSchool = previousSchool;
		this.currentClass = currentClass;
		this.password = password;
		this.dob = dob;
		this.gender = gender;
	}

	public Long getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(Long registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getGaurdianName() {
		return gaurdianName;
	}

	public void setGaurdianName(String gaurdianName) {
		this.gaurdianName = gaurdianName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Address getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public Address getMailingAddress() {
		return mailingAddress;
	}

	public void setMailingAddress(Address mailingAddress) {
		this.mailingAddress = mailingAddress;
	}

	public String getPreviousSchool() {
		return previousSchool;
	}

	public void setPreviousSchool(String previousSchool) {
		this.previousSchool = previousSchool;
	}

	public String getCurrentClass() {
		return currentClass;
	}

	public void setCurrentClass(String currentClass) {
		this.currentClass = currentClass;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
