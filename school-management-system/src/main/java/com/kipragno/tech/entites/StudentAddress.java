package com.kipragno.tech.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_address")
public class StudentAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	private Long addressId;
	@Column(name = "address_type" , nullable = false)
	private String addressType;
	@Column(name = "address" , nullable = false)
	private String address;
	@Column(name = "state", nullable = false)
	private String state;
	@Column(name = "city", nullable = false)
	private String city;
	@Column(name = "pincode", nullable = false)
	private Long pincode;
	@Column(name = "country", nullable = false)
	private String country;

	public StudentAddress() {
		super();
	}

	public StudentAddress(Long addressId, String addressType, String address, String state, String city, Long pincode, String country) {
		super();
		this.addressId = addressId;
		this.addressType = addressType;
		this.address = address;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.country = country;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	
}
