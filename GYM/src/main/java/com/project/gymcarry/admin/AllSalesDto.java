package com.project.gymcarry.admin;

public class AllSalesDto {
	private int month;
	private int day;
	private String crname;
	private long total;
	private String engmonth;
	public AllSalesDto() {
	}
	public AllSalesDto(int month, int day, String crname, long total, String engmonth) {
		this.month = month;
		this.day = day;
		this.crname = crname;
		this.total = total;
		this.engmonth = engmonth;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getCrname() {
		return crname;
	}
	public void setCrname(String crname) {
		this.crname = crname;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public String getEngmonth() {
		return engmonth;
	}
	public void setEngmonth(String engmonth) {
		this.engmonth = engmonth;
	}
	
	
}
