package com.ordermatching.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class CustInfo {
	@Id
	private String CustomerCode;
	@Column(name="EmailAddress")
	private String emailAddress;
	private String Password;
	
	public String getCustomerCode() {
		return CustomerCode;
	}

	public void setCustomerCode(String customerCode) {
		CustomerCode = customerCode;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public CustInfo() {
		
	}

	public CustInfo(String customerCode,String emailAddress, String password) {
		CustomerCode = customerCode;
		this.emailAddress = emailAddress;
		Password = password;
	}
}
