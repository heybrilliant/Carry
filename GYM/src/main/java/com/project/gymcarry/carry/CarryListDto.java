package com.project.gymcarry.carry;

public class CarryListDto {

	private int cridx;
	private String crnick;
	private String placename;
	private int proprice1;
	private String crcerti1;
	private String crcerti2;
	private String crcerti3;
	private String crcerti4;
	private String crcerti5;
	
	
	// 기본 생성자
	public CarryListDto() {}


	public CarryListDto(int cridx, String crnick, String placename, int proprice1, String crcerti1, String crcerti2,
			String crcerti3, String crcerti4, String crcerti5) {
		super();
		this.cridx = cridx;
		this.crnick = crnick;
		this.placename = placename;
		this.proprice1 = proprice1;
		this.crcerti1 = crcerti1;
		this.crcerti2 = crcerti2;
		this.crcerti3 = crcerti3;
		this.crcerti4 = crcerti4;
		this.crcerti5 = crcerti5;
	}


	public int getCridx() {
		return cridx;
	}


	public void setCridx(int cridx) {
		this.cridx = cridx;
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


	public int getProprice1() {
		return proprice1;
	}


	public void setProprice1(int proprice1) {
		this.proprice1 = proprice1;
	}


	public String getCrcerti1() {
		return crcerti1;
	}


	public void setCrcerti1(String crcerti1) {
		this.crcerti1 = crcerti1;
	}


	public String getCrcerti2() {
		return crcerti2;
	}


	public void setCrcerti2(String crcerti2) {
		this.crcerti2 = crcerti2;
	}


	public String getCrcerti3() {
		return crcerti3;
	}


	public void setCrcerti3(String crcerti3) {
		this.crcerti3 = crcerti3;
	}


	public String getCrcerti4() {
		return crcerti4;
	}


	public void setCrcerti4(String crcerti4) {
		this.crcerti4 = crcerti4;
	}


	public String getCrcerti5() {
		return crcerti5;
	}


	public void setCrcerti5(String crcerti5) {
		this.crcerti5 = crcerti5;
	}


	@Override
	public String toString() {
		return "CarryListDto [cridx=" + cridx + ", crnick=" + crnick + ", placename=" + placename + ", proprice1="
				+ proprice1 + ", crcerti1=" + crcerti1 + ", crcerti2=" + crcerti2 + ", crcerti3=" + crcerti3
				+ ", crcerti4=" + crcerti4 + ", crcerti5=" + crcerti5 + "]";
	}


	
}
