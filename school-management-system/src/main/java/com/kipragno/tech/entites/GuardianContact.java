package com.kipragno.tech.entites;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "guardian_contact")
public class GuardianContact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contact_id")
	private Long contactId;

	@Embedded
	private GuardianDetails guardianDetails;

	@OneToOne
	@JoinColumn(name = "permanent_address_id")
	private StudentAddress permanentAddress;

	@OneToOne
	@JoinColumn(name = "mailing_address_id")
	private StudentAddress mailingAddress;

	public GuardianContact() {
		super();
	}

	public GuardianContact(Long contactId, GuardianDetails guardianDetails, StudentAddress permanentAddress,
			StudentAddress mailingAddress) {
		super();
		this.contactId = contactId;
		this.guardianDetails = guardianDetails;
		this.permanentAddress = permanentAddress;
		this.mailingAddress = mailingAddress;
	}

	public StudentAddress getMailingAddress() {
		return mailingAddress;
	}

	public void setMailingAddress(StudentAddress mailingAddress) {
		this.mailingAddress = mailingAddress;
	}

	public StudentAddress getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(StudentAddress permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public GuardianDetails getGuardianDetails() {
		return guardianDetails;
	}

	public void setGuardianDetails(GuardianDetails guardianDetails) {
		this.guardianDetails = guardianDetails;
	}

}
