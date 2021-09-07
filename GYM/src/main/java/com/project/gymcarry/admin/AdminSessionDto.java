package com.project.gymcarry.admin;

public class AdminSessionDto {

	private String adminid;
	private String adminpw;
	
	// 기본 생성자
	public AdminSessionDto() {}
	
	public AdminSessionDto(String adminid, String adminpw) {
		this.adminid = adminid;
		this.adminpw = adminpw;
	}

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getAdminpw() {
		return adminpw;
	}

	public void setAdminpw(String adminpw) {
		this.adminpw = adminpw;
	}

	@Override
	public String toString() {
		return "AdminSessionDto [adminid=" + adminid + ", adminpw=" + adminpw + "]";
	}
	
	

}
