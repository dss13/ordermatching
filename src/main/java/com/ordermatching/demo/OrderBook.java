package com.ordermatching.demo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"OrderBook\"")
public class OrderBook {
	@Id
	String OrderNumber;
	String SecurityCode;
	Date TradeTime;
	Float Price;
	String Direction;
	int Quantity;
	String OrderStatus;
	String PriceCondition;
	String CustomerCode;
	
	public OrderBook(String securityCode, Date tradeTime, Float price, String direction,
			int quantity, String priceCondition, String customerCode) {
		super();
		Date d = new Date();
		OrderNumber = d.toString() + Math.random();
		SecurityCode = securityCode;
		TradeTime = new Date();
		Price = price;
		Direction = direction;
		Quantity = quantity;
		OrderStatus = "Pending";
		PriceCondition = priceCondition;
		CustomerCode = customerCode;
	}
}
