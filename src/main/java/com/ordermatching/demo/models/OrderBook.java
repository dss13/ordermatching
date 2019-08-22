package com.ordermatching.demo.models;

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
	private String OrderNumber;
	private String SecurityCode;
	@Temporal(TemporalType.TIMESTAMP)
	private Date TradeTime;
	private Float Price;
	private String Direction;
	private int Quantity;
	private String OrderStatus;
	private String PriceCondition;
	private String CustomerCode;

	public OrderBook(String orderNumber, String securityCode, Date tradeTime, Float price, String direction,
			int quantity, String orderStatus, String priceCondition, String customerCode) {
		super();
		OrderNumber = orderNumber;
		SecurityCode = securityCode;
		TradeTime = new Date();
		Price = price;
		Direction = direction;
		Quantity = quantity;
		OrderStatus = "Pending";
		PriceCondition = priceCondition;
		CustomerCode = customerCode;
	}

	public String getOrderNumber() {
		return OrderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		OrderNumber = orderNumber;
	}

	public String getSecurityCode() {
		return SecurityCode;
	}

	public void setSecurityCode(String securityCode) {
		SecurityCode = securityCode;
	}

	public Date getTradeTime() {
		return TradeTime;
	}

	public void setTradeTime(Date tradeTime) {
		TradeTime = tradeTime;
	}

	public Float getPrice() {
		return Price;
	}

	public void setPrice(Float price) {
		Price = price;
	}

	public String getDirection() {
		return Direction;
	}

	public void setDirection(String direction) {
		Direction = direction;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public String getOrderStatus() {
		return OrderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		OrderStatus = orderStatus;
	}

	public String getPriceCondition() {
		return PriceCondition;
	}

	public void setPriceCondition(String priceCondition) {
		PriceCondition = priceCondition;
	}

	public String getCustomerCode() {
		return CustomerCode;
	}

	public void setCustomerCode(String customerCode) {
		CustomerCode = customerCode;
	}

	public OrderBook() {
		super();
	}
}
