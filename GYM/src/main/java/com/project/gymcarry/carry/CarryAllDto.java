package com.project.gymcarry.carry;

public class CarryAllDto {
	
	private int cridx;
	private String crid;
	private String crpw;
	private String crname;
	private String crnick;
	private String crgender;
	private String crphone;
	private String crintro;
	private String crdepart;
	private String crfield;
	private String crcerti1;
	private String crcerti2;
	private String crcerti3;
	private String crcerti4;
	private String crcerti5;
	private int proprice1;
	private int proprice5;
	private int proprice10;
	private int proprice20;
	private String placename;
	private String placeaddress;
	private String placephone;
	private int reviewidx;
	private String reviewcontent;
	private int memidx;
	private String memnick;
	public CarryAllDto(int cridx, String crid, String crpw, String crname, String crnick, String crgender,
			String crphone, String crintro, String crdepart, String crfield, String crcerti1, String crcerti2,
			String crcerti3, String crcerti4, String crcerti5, int proprice1, int proprice5, int proprice10,
			int proprice20, String placename, String placeaddress, String placephone, int reviewidx,
			String reviewcontent, int memidx, String memnick) {
		this.cridx = cridx;
		this.crid = crid;
		this.crpw = crpw;
		this.crname = crname;
		this.crnick = crnick;
		this.crgender = crgender;
		this.crphone = crphone;
		this.crintro = crintro;
		this.crdepart = crdepart;
		this.crfield = crfield;
		this.crcerti1 = crcerti1;
		this.crcerti2 = crcerti2;
		this.crcerti3 = crcerti3;
		this.crcerti4 = crcerti4;
		this.crcerti5 = crcerti5;
		this.proprice1 = proprice1;
		this.proprice5 = proprice5;
		this.proprice10 = proprice10;
		this.proprice20 = proprice20;
		this.placename = placename;
		this.placeaddress = placeaddress;
		this.placephone = placephone;
		this.reviewidx = reviewidx;
		this.reviewcontent = reviewcontent;
		this.memidx = memidx;
		this.memnick = memnick;
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
	public String getCrintro() {
		return crintro;
	}
	public void setCrintro(String crintro) {
		this.crintro = crintro;
	}
	public String getCrdepart() {
		return crdepart;
	}
	public void setCrdepart(String crdepart) {
		this.crdepart = crdepart;
	}
	public String getCrfield() {
		return crfield;
	}
	public void setCrfield(String crfield) {
		this.crfield = crfield;
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
	public int getProprice1() {
		return proprice1;
	}
	public void setProprice1(int proprice1) {
		this.proprice1 = proprice1;
	}
	public int getProprice5() {
		return proprice5;
	}
	public void setProprice5(int proprice5) {
		this.proprice5 = proprice5;
	}
	public int getProprice10() {
		return proprice10;
	}
	public void setProprice10(int proprice10) {
		this.proprice10 = proprice10;
	}
	public int getProprice20() {
		return proprice20;
	}
	public void setProprice20(int proprice20) {
		this.proprice20 = proprice20;
	}
	public String getPlacename() {
		return placename;
	}
	public void setPlacename(String placename) {
		this.placename = placename;
	}
	public String getPlaceaddress() {
		return placeaddress;
	}
	public void setPlaceaddress(String placeaddress) {
		this.placeaddress = placeaddress;
	}
	public String getPlacephone() {
		return placephone;
	}
	public void setPlacephone(String placephone) {
		this.placephone = placephone;
	}
	public int getReviewidx() {
		return reviewidx;
	}
	public void setReviewidx(int reviewidx) {
		this.reviewidx = reviewidx;
	}
	public String getReviewcontent() {
		return reviewcontent;
	}
	public void setReviewcontent(String reviewcontent) {
		this.reviewcontent = reviewcontent;
	}
	public int getMemidx() {
		return memidx;
	}
	public void setMemidx(int memidx) {
		this.memidx = memidx;
	}
	public String getMemnick() {
		return memnick;
	}
	public void setMemnick(String memnick) {
		this.memnick = memnick;
	}
	@Override
	public String toString() {
		return "CarryAllDto [cridx=" + cridx + ", crid=" + crid + ", crpw=" + crpw + ", crname=" + crname + ", crnick="
				+ crnick + ", crgender=" + crgender + ", crphone=" + crphone + ", crintro=" + crintro + ", crdepart="
				+ crdepart + ", crfield=" + crfield + ", crcerti1=" + crcerti1 + ", crcerti2=" + crcerti2
				+ ", crcerti3=" + crcerti3 + ", crcerti4=" + crcerti4 + ", crcerti5=" + crcerti5 + ", proprice1="
				+ proprice1 + ", proprice5=" + proprice5 + ", proprice10=" + proprice10 + ", proprice20=" + proprice20
				+ ", placename=" + placename + ", placeaddress=" + placeaddress + ", placephone=" + placephone
				+ ", reviewidx=" + reviewidx + ", reviewcontent=" + reviewcontent + ", memidx=" + memidx + ", memnick="
				+ memnick + "]";
	}
	
	

}
