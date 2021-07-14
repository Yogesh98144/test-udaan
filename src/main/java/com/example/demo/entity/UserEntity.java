package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="pid")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE) 
	public Integer userId;
	
	public String name;
	
	@Column(name="mobile_number")
	public String mobileNumber;
	
	@Column(name="pin_code")
	public Integer pinCode;

	public UserEntity() {
		super();
	}

	public UserEntity(Integer userId, String name, String mobileNumber, Integer pinCode) {
		super();
		this.userId = userId;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.pinCode = pinCode;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}
	
}
