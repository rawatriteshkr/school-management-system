package com.kipragno.tech.entites;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StudentFullName {

	@Column(name="first_name", nullable = false)
	private String firstName;
	@Column(name="middle_name")
	private String middleName;
	@Column(name="last_name", nullable = false)
	private String lastName;

	public StudentFullName() {
		super();
	}

	public StudentFullName(String firstName, String middleName, String lastName) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
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

}
