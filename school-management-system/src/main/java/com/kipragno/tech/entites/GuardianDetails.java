package com.kipragno.tech.entites;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class GuardianDetails {

	@Column(name="guardian_name", nullable = false)
	private String guardianName;
	@Column(name="relationship", nullable = false)
	private String relationship;
	@Column(name="guardian_phone", nullable = false)
	private Long phone;
	@Column(name="guardian_government_id_type", nullable = false)
	private String guardianGovernmentIdType;
	@Column(name="guardian_government_id_no", nullable = false)
	private String guardianGovernmentIdNo;
	@Column(name="occupation", nullable = false)
	private String occupation;

	public GuardianDetails() {
		super();
	}

	public GuardianDetails(String guardianName, String relationship, Long phone, String guardianGovernmentIdType,
			String guardianGovernmentIdNo, String occupation) {
		super();
		this.guardianName = guardianName;
		this.relationship = relationship;
		this.phone = phone;
		this.guardianGovernmentIdType = guardianGovernmentIdType;
		this.guardianGovernmentIdNo = guardianGovernmentIdNo;
		this.occupation = occupation;
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

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
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

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

}
