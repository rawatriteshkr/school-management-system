package com.kipragno.tech.entites;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable
public class StudentContact {

	@Column(name="phone", nullable = false)
	private Long phone;
	@Column(name="government_id_type", nullable = false)
	private String governmentIdType;
	@Column(name="government_id_no", nullable = false)
	private String governmentIdNo;
	@Column(name="pic")
	@Lob
	private byte[] pic;

	public StudentContact() {
		super();
	}

	public StudentContact(Long phone, String governmentIdType, String governmentIdNo, byte[] pic) {
		super();
		this.phone = phone;
		this.governmentIdType = governmentIdType;
		this.governmentIdNo = governmentIdNo;
		this.pic = pic;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
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

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

}
