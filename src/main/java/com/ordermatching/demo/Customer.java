package com.ordermatching.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"CustInfo\"")
public class Customer {
	@Id
	private String CustomerCode;
	private String EmailAddress;
	private String Password;
	
	public Customer() {
		
	}
	
	public Customer(String c, String e, String p) {
		this.CustomerCode = c;
		this.EmailAddress = e;
		this.Password = p;
	}

	public String getCustomerCode() {
		return CustomerCode;
	}

	public void setCustomerCode(String customerCode) {
		CustomerCode = customerCode;
	}

	public String getEmailAddress() {
		return EmailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	
}



