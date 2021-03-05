package com.kipragno.tech.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_personal_details")
public class StudentPersonalDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "personal_detail_id")
	private Long personalDetailId;
	@Column(name = "gender", nullable = false)
	private String gender;
	@Column(name = "blood_group")
	private String bloodGroup;
	@Column(name = "weight")
	private Double weight;
	@Column(name = "height")
	private Double height;
	@Column(name = "language_1", nullable = false)
	private String language_1;
	@Column(name = "language_2")
	private String language_2;
	@Column(name = "language_3")
	private String language_3;
	@Column(name = "religion")
	private String religion;
	@Column(name = "disability", nullable = false)
	private String disability;
	@Column(name = "disability_type", nullable = false)
	private String disabilityType;

	public StudentPersonalDetails() {
		super();
	}

	public StudentPersonalDetails(Long personalDetailId, String gender, String bloodGroup, Double weight, Double height,
			String language_1, String language_2, String language_3, String religion, String disability,
			String disabilityType) {
		super();
		this.personalDetailId = personalDetailId;
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
	}

	public Long getPersonalDetailId() {
		return personalDetailId;
	}

	public void setPersonalDetailId(Long personalDetailId) {
		this.personalDetailId = personalDetailId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

}
