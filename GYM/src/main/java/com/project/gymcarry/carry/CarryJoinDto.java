package com.project.gymcarry.carry;

public class CarryJoinDto {
	
	private int cridx;
	private String crid;
	private String crpw;
	private String crname;
	private String crnick;
	private String crgender;
	private String crphone;
	private String placename;
	public CarryJoinDto() {
	}
	
	public CarryJoinDto(int cridx, String crid, String crpw, String crname, String crnick, String crgender,
			String crphone, String placename) {
		super();
		this.cridx = cridx;
		this.crid = crid;
		this.crpw = crpw;
		this.crname = crname;
		this.crnick = crnick;
		this.crgender = crgender;
		this.crphone = crphone;
		this.placename = placename;
	}

	public int getCridx() {
		return cridx;
	}
	public void setCridx(int cridx) {
		this.cridx = cridx;
	}
	public String getCrid() {
		return crid;
	}
	public void setCrid(String crid) {
		this.crid = crid;
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
	
	public String getPlacename() {
		return placename;
	}
	public void setPlacename(String placename) {
		this.placename = placename;
	}

	@Override
	public String toString() {
		return "CarryJoinDto [cridx=" + cridx + ", crid=" + crid + ", crpw=" + crpw + ", crname=" + crname + ", crnick="
				+ crnick + ", crgender=" + crgender + ", crphone=" + crphone + ", placename=" + placename + "]";
	}
	
}
