package com.project.gymcarry.carry;

public class CarryDto {
	private int cridx;
	private int crid;
	private String crpw;
	private String crname;
	private String crnick;
	private String placename;
	public CarryDto(int cridx, int crid, String crpw, String crname, String crnick, String placename) {
		super();
		this.cridx = cridx;
		this.crid = crid;
		this.crpw = crpw;
		this.crname = crname;
		this.crnick = crnick;
		this.placename = placename;
	}
	public int getCridx() {
		return cridx;
	}
	public void setCridx(int cridx) {
		this.cridx = cridx;
	}
	public int getCrid() {
		return crid;
	}
	public void setCrid(int crid) {
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
	public String getPlacename() {
		return placename;
	}
	public void setPlacename(String placename) {
		this.placename = placename;
	}
	@Override
	public String toString() {
		return "CarryDto [cridx=" + cridx + ", crid=" + crid + ", crpw=" + crpw + ", crname=" + crname + ", crnick="
				+ crnick + ", placename=" + placename + "]";
	}
	
	
}
