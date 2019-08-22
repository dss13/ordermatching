package com.ordermatching.demo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "\"OrderBook\"")
public class OrderBook {
	@Id
	String OrderNumber;
	String SecurityCode;
	@Temporal(TemporalType.TIMESTAMP)
	Date TradeTime;
	Float Price;
	String Direction;
	int Quantity;
	String OrderStatus;
	String PriceCondition;
	String CustomerCode;
	
	

	public String getCustomerCode() {
		return CustomerCode;
	}

	public OrderBook(String orderNumber, String securityCode, Date tradeTime, Float price, String direction,
			int quantity, String orderStatus, String priceCondition, String customerCode) {
		super();
		OrderNumber = orderNumber;
		SecurityCode = securityCode;
		TradeTime = tradeTime;
		Price = price;
		Direction = direction;
		Quantity = quantity;
		OrderStatus = orderStatus;
		PriceCondition = priceCondition;
		CustomerCode = customerCode;
	}

	public void setCustomerCode(String customerCode) {
		CustomerCode = customerCode;
	}

	public OrderBook() {
		super();
	}
}
