package com.kipragno.tech.model;

import java.io.File;
import java.util.Date;

public class RegisterStudent {

	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private Long phone;
	private String dob;
	// pic
	private File pic;
	private String governmentIdType;
	private String governmentIdNo;
	private String guardianName;
	private String relationship;
	private String occupation;
	private String guardianGovernmentIdType;
	private String guardianGovernmentIdNo;
	private Long guardianPhone;
	private String feesPaid;
	private String receiptNo;
	private String guardian_2_Name;
	private String guardian_2_relationship;
	private String guardian_2_occupation;
	private String guardian_2_GovernmentIdType;
	private String guardian_2_GovernmentIdNo;
	private Long guardian_2_Phone;
	private String permanentAddress;
	private String permanentState;
	private String permanentCity;
	private Long permanentPincode;
	private String mailingAddress;
	private String mailingState;
	private String mailingCity;
	private Long mailingPincode;
	private String gender;
	private String bloodGroup;
	private Double weight;
	private Double height;
	private String language_1;
	private String language_2;
	private String language_3;
	private String religion;
	private String disability;
	private String disabilityType;
	private String previousSchool;
	private String className;
	private String section;
	private String board;
	private String tc;
	private Double percentage;
	private Long academicYear;

	public RegisterStudent() {
		super();
	}

	public RegisterStudent(String firstName, String middleName, String lastName, String email, Long phone, String dob,
			File pic, String governmentIdType, String governmentIdNo, String guardianName, String relationship,
			String occupation, String guardianGovernmentIdType, String guardianGovernmentIdNo, Long guardianPhone,
			String feesPaid, String receiptNo, String guardian_2_Name, String guardian_2_relationship,
			String guardian_2_occupation, String guardian_2_GovernmentIdType, String guardian_2_GovernmentIdNo,
			Long guardian_2_Phone, String permanentAddress, String permanentState, String permanentCity,
			Long permanentPincode, String mailingAddress, String mailingState, String mailingCity, Long mailingPincode,
			String gender, String bloodGroup, Double weight, Double height, String language_1, String language_2,
			String language_3, String religion, String disability, String disabilityType, String previousSchool,
			String className, String section, String board, String tc, Double percentage, Long academicYear) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
		this.pic = pic;
		this.governmentIdType = governmentIdType;
		this.governmentIdNo = governmentIdNo;
		this.guardianName = guardianName;
		this.relationship = relationship;
		this.occupation = occupation;
		this.guardianGovernmentIdType = guardianGovernmentIdType;
		this.guardianGovernmentIdNo = guardianGovernmentIdNo;
		this.guardianPhone = guardianPhone;
		this.feesPaid = feesPaid;
		this.receiptNo = receiptNo;
		this.guardian_2_Name = guardian_2_Name;
		this.guardian_2_relationship = guardian_2_relationship;
		this.guardian_2_occupation = guardian_2_occupation;
		this.guardian_2_GovernmentIdType = guardian_2_GovernmentIdType;
		this.guardian_2_GovernmentIdNo = guardian_2_GovernmentIdNo;
		this.guardian_2_Phone = guardian_2_Phone;
		this.permanentAddress = permanentAddress;
		this.permanentState = permanentState;
		this.permanentCity = permanentCity;
		this.permanentPincode = permanentPincode;
		this.mailingAddress = mailingAddress;
		this.mailingState = mailingState;
		this.mailingCity = mailingCity;
		this.mailingPincode = mailingPincode;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
		this.weight = weight;
		this.height = height;
		this.language_1 = language_1;
		this.language_2 = language_2;
		this.language_3 = language_3;
		this.religion = religion;
		this.disability = disability;
		this.disabilityType = disabilityType;
		this.previousSchool = previousSchool;
		this.className = className;
		this.section = section;
		this.board = board;
		this.tc = tc;
		this.percentage = percentage;
		this.academicYear = academicYear;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public File getPic() {
		return pic;
	}

	public void setPic(File pic) {
		this.pic = pic;
	}

	public String getGovernmentIdType() {
		return governmentIdType;
	}

	public void setGovernmentIdType(String governmentIdType) {
		this.governmentIdType = governmentIdType;
	}

	public String getGovernmentIdNo() {
		return governmentIdNo;
	}

	public void setGovernmentIdNo(String governmentIdNo) {
		this.governmentIdNo = governmentIdNo;
	}

	public String getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getGuardianGovernmentIdType() {
		return guardianGovernmentIdType;
	}

	public void setGuardianGovernmentIdType(String guardianGovernmentIdType) {
		this.guardianGovernmentIdType = guardianGovernmentIdType;
	}

	public String getGuardianGovernmentIdNo() {
		return guardianGovernmentIdNo;
	}

	public void setGuardianGovernmentIdNo(String guardianGovernmentIdNo) {
		this.guardianGovernmentIdNo = guardianGovernmentIdNo;
	}

	public Long getGuardianPhone() {
		return guardianPhone;
	}

	public void setGuardianPhone(Long guardianPhone) {
		this.guardianPhone = guardianPhone;
	}

	public String getFeesPaid() {
		return feesPaid;
	}

	public void setFeesPaid(String feesPaid) {
		this.feesPaid = feesPaid;
	}

	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	public String getGuardian_2_Name() {
		return guardian_2_Name;
	}

	public void setGuardian_2_Name(String guardian_2_Name) {
		this.guardian_2_Name = guardian_2_Name;
	}

	public String getGuardian_2_relationship() {
		return guardian_2_relationship;
	}

	public void setGuardian_2_relationship(String guardian_2_relationship) {
		this.guardian_2_relationship = guardian_2_relationship;
	}

	public String getGuardian_2_occupation() {
		return guardian_2_occupation;
	}

	public void setGuardian_2_occupation(String guardian_2_occupation) {
		this.guardian_2_occupation = guardian_2_occupation;
	}

	public String getGuardian_2_GovernmentIdType() {
		return guardian_2_GovernmentIdType;
	}

	public void setGuardian_2_GovernmentIdType(String guardian_2_GovernmentIdType) {
		this.guardian_2_GovernmentIdType = guardian_2_GovernmentIdType;
	}

	public String getGuardian_2_GovernmentIdNo() {
		return guardian_2_GovernmentIdNo;
	}

	public void setGuardian_2_GovernmentIdNo(String guardian_2_GovernmentIdNo) {
		this.guardian_2_GovernmentIdNo = guardian_2_GovernmentIdNo;
	}

	public Long getGuardian_2_Phone() {
		return guardian_2_Phone;
	}

	public void setGuardian_2_Phone(Long guardian_2_Phone) {
		this.guardian_2_Phone = guardian_2_Phone;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getPermanentState() {
		return permanentState;
	}

	public void setPermanentState(String permanentState) {
		this.permanentState = permanentState;
	}

	public String getPermanentCity() {
		return permanentCity;
	}

	public void setPermanentCity(String permanentCity) {
		this.permanentCity = permanentCity;
	}

	public Long getPermanentPincode() {
		return permanentPincode;
	}

	public void setPermanentPincode(Long permanentPincode) {
		this.permanentPincode = permanentPincode;
	}

	public String getMailingAddress() {
		return mailingAddress;
	}

	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}

	public String getMailingState() {
		return mailingState;
	}

	public void setMailingState(String mailingState) {
		this.mailingState = mailingState;
	}

	public String getMailingCity() {
		return mailingCity;
	}

	public void setMailingCity(String mailingCity) {
		this.mailingCity = mailingCity;
	}

	public Long getMailingPincode() {
		return mailingPincode;
	}

	public void setMailingPincode(Long mailingPincode) {
		this.mailingPincode = mailingPincode;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public String getLanguage_1() {
		return language_1;
	}

	public void setLanguage_1(String language_1) {
		this.language_1 = language_1;
	}

	public String getLanguage_2() {
		return language_2;
	}

	public void setLanguage_2(String language_2) {
		this.language_2 = language_2;
	}

	public String getLanguage_3() {
		return language_3;
	}

	public void setLanguage_3(String language_3) {
		this.language_3 = language_3;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getDisability() {
		return disability;
	}

	public void setDisability(String disability) {
		this.disability = disability;
	}

	public String getDisabilityType() {
		return disabilityType;
	}

	public void setDisabilityType(String disabilityType) {
		this.disabilityType = disabilityType;
	}

	public String getPreviousSchool() {
		return previousSchool;
	}

	public void setPreviousSchool(String previousSchool) {
		this.previousSchool = previousSchool;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public String getTc() {
		return tc;
	}

	public void setTc(String tc) {
		this.tc = tc;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public Long getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(Long academicYear) {
		this.academicYear = academicYear;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
