package com.project.gymcarry.carry;

import org.springframework.web.multipart.MultipartFile;

public class CarryDto {

	private int cridx;
	private MultipartFile crphoto;
	private String cremail;
	private String crpw;
	private String crname;
	private String crnick;
	private String crphone;
	private String placename;
	private String crgender;
	private String crintro;
	private String crdepart;
	private String crfield;
	private int faceornot;
	
	
	// 기본 생성자
	public CarryDto() {}
	
	
	public int getCridx() {
		return cridx;
	}
	public void setCridx(int cridx) {
		this.cridx = cridx;
	}
	public MultipartFile getCrphoto() {
		return crphoto;
	}
	public void setCrphoto(MultipartFile crphoto) {
		this.crphoto = crphoto;
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
	public String getCrgender() {
		return crgender;
	}
	public void setCrgender(String crgender) {
		this.crgender = crgender;
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
	public int getFaceornot() {
		return faceornot;
	}
	public void setFaceornot(int faceornot) {
		this.faceornot = faceornot;
	}
	
	
	
	
	@Override
	public String toString() {
		return "CarryDto2 [cridx=" + cridx + ", crphoto=" + crphoto + ", cremail=" + cremail + ", crpw=" + crpw
				+ ", crname=" + crname + ", crnick=" + crnick + ", crphone=" + crphone + ", placename=" + placename
				+ ", crgender=" + crgender + ", crintro=" + crintro + ", crdepart=" + crdepart + ", crfield=" + crfield
				+ ", faceornot=" + faceornot + "]";
	}
	
	
	
	
	
}
