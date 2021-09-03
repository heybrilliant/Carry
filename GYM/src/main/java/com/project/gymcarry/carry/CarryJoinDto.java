package com.project.gymcarry.carry;

public class CarryJoinDto {
	
	private int cridx;
	private String cremail;
	private String crpw;
	private String crname;
	private String crnick;
	private String crgender;
	private String crphone;
	
	public CarryJoinDto() {
	}
	
	public CarryJoinDto(int cridx, String cremail, String crpw, String crname, String crnick, String crgender,
			String crphone) {
		super();
		this.cridx = cridx;
		this.cremail = cremail;
		this.crpw = crpw;
		this.crname = crname;
		this.crnick = crnick;
		this.crgender = crgender;
		this.crphone = crphone;
	}
	public int getCridx() {
		return cridx;
	}
	public void setCridx(int cridx) {
		this.cridx = cridx;
	}
	public String getCremail() {
		return cremail;
	}
	public void setCremail(String cremail) {
		this.cremail = cremail;
	}
	public String getCrpw() {
		return crpw;
	}
	public void setCrpw(String crpw) {
		this.crpw = crpw;
	}
	public String getCrname() {
		return crname;
	}
	public void setCrname(String crname) {
		this.crname = crname;
	}
	public String getCrnick() {
		return crnick;
	}
	public void setCrnick(String crnick) {
		this.crnick = crnick;
	}
	public String getCrgender() {
		return crgender;
	}
	public void setCrgender(String crgender) {
		this.crgender = crgender;
	}
	public String getCrphone() {
		return crphone;
	}
	public void setCrphone(String crphone) {
		this.crphone = crphone;
	}
	@Override
	public String toString() {
		return "CarryJoinDto [cridx=" + cridx + ", cremail=" + cremail + ", crpw=" + crpw + ", crname=" + crname
				+ ", crnick=" + crnick + ", crgender=" + crgender + ", crphone=" + crphone + "]";
	}

	
}
