package com.project.gymcarry.admin;

public class AllSalesDto {
	private int month;
	private String crname;
	private long total;
	public AllSalesDto() {
	}
	public AllSalesDto(int month, String crname, long total) {
		super();
		this.month = month;
		this.crname = crname;
		this.total = total;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
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
	
}
