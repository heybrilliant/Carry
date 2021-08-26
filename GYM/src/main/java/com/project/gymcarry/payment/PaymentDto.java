package com.project.gymcarry.payment;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PaymentDto {

	private int payIDX;
	private int payPrice;
	@JsonFormat(pattern = "HH:mm a")
	private Timestamp payDate;
	private int proNum;
	
	
	public int getPayIDX() {
		return payIDX;
	}
	public void setPayIDX(int payIDX) {
		this.payIDX = payIDX;
	}
	public int getPayPrice() {
		return payPrice;
	}
	public void setPayPrice(int payPrice) {
		this.payPrice = payPrice;
	}
	public Timestamp getPayDate() {
		return payDate;
	}
	public void setPayDate(Timestamp payDate) {
		this.payDate = payDate;
	}
	public int getProNum() {
		return proNum;
	}
	public void setProNum(int proNum) {
		this.proNum = proNum;
	}
	
	
	@Override
	public String toString() {
		return "paymentDto [payIDX=" + payIDX + ", payPrice=" + payPrice + ", payDate=" + payDate + ", proNum=" + proNum
				+ "]";
	}
	
	
	public PaymentDto(int payIDX, int payPrice, Timestamp payDate, int proNum) {
		super();
		this.payIDX = payIDX;
		this.payPrice = payPrice;
		this.payDate = payDate;
		this.proNum = proNum;
	}
	
	
	
	
}
