package com.ordermatching.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SecuritiesMaster {
	@Id
	private String SecurityCode;
	private String CompanyName;
	private Float SellingPrice;
	private Float BuyingPrice;
	
	public SecuritiesMaster(String securityCode, String companyName, Float sellingPrice, Float buyingPrice) {
		super();
		SecurityCode = securityCode;
		CompanyName = companyName;
		SellingPrice = sellingPrice;
		BuyingPrice = buyingPrice;
	}

	public SecuritiesMaster() {
		super();
	}

	public String getSecurityCode() {
		return SecurityCode;
	}

	public void setSecurityCode(String securityCode) {
		SecurityCode = securityCode;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public Float getSellingPrice() {
		return SellingPrice;
	}

	public void setSellingPrice(Float sellingPrice) {
		SellingPrice = sellingPrice;
	}

	public Float getBuyingPrice() {
		return BuyingPrice;
	}

	public void setBuyingPrice(Float buyingPrice) {
		BuyingPrice = buyingPrice;
	}
	
}
