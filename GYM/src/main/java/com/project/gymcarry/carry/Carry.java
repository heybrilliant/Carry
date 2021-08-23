package com.project.gymcarry.carry;

public class Carry {

	// 빈즈 Beans 형태
	private int crIDX;
	private String email;
	private String crPW;
	private String crName;
	private String crNick;
	private String crPhone;
	private int crBirth;
	private String crGender;
	private String crPhoto;
	private String crIntro;
	private String crBPhoto;
	private String crDepart;
	private String crField;
	private String crCerti1;
	private String crCerti2;
	private String crCerti3;
	private String crCerti4;
	private String crCerti5;
	public int getCrIDX() {
		return crIDX;
	}
	public void setCrIDX(int crIDX) {
		this.crIDX = crIDX;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCrPW() {
		return crPW;
	}
	public void setCrPW(String crPW) {
		this.crPW = crPW;
	}
	public String getCrName() {
		return crName;
	}
	public void setCrName(String crName) {
		this.crName = crName;
	}
	public String getCrNick() {
		return crNick;
	}
	public void setCrNick(String crNick) {
		this.crNick = crNick;
	}
	public String getCrPhone() {
		return crPhone;
	}
	public void setCrPhone(String crPhone) {
		this.crPhone = crPhone;
	}
	public int getCrBirth() {
		return crBirth;
	}
	public void setCrBirth(int crBirth) {
		this.crBirth = crBirth;
	}
	public String getCrGender() {
		return crGender;
	}
	public void setCrGender(String crGender) {
		this.crGender = crGender;
	}
	public String getCrPhoto() {
		return crPhoto;
	}
	public void setCrPhoto(String crPhoto) {
		this.crPhoto = crPhoto;
	}
	public String getCrIntro() {
		return crIntro;
	}
	public void setCrIntro(String crIntro) {
		this.crIntro = crIntro;
	}
	public String getCrBPhoto() {
		return crBPhoto;
	}
	public void setCrBPhoto(String crBPhoto) {
		this.crBPhoto = crBPhoto;
	}
	public String getCrDepart() {
		return crDepart;
	}
	public void setCrDepart(String crDepart) {
		this.crDepart = crDepart;
	}
	public String getCrField() {
		return crField;
	}
	public void setCrField(String crField) {
		this.crField = crField;
	}
	public String getCrCerti1() {
		return crCerti1;
	}
	public void setCrCerti1(String crCerti1) {
		this.crCerti1 = crCerti1;
	}
	public String getCrCerti2() {
		return crCerti2;
	}
	public void setCrCerti2(String crCerti2) {
		this.crCerti2 = crCerti2;
	}
	public String getCrCerti3() {
		return crCerti3;
	}
	public void setCrCerti3(String crCerti3) {
		this.crCerti3 = crCerti3;
	}
	public String getCrCerti4() {
		return crCerti4;
	}
	public void setCrCerti4(String crCerti4) {
		this.crCerti4 = crCerti4;
	}
	public String getCrCerti5() {
		return crCerti5;
	}
	public void setCrCerti5(String crCerti5) {
		this.crCerti5 = crCerti5;
	}
	
	
	
	public Carry(int crIDX, String email, String crPW, String crName, String crNick, String crPhone, int crBirth,
			String crGender, String crPhoto, String crIntro, String crBPhoto, String crDepart, String crField,
			String crCerti1, String crCerti2, String crCerti3, String crCerti4, String crCerti5) {
		this.crIDX = crIDX;
		this.email = email;
		this.crPW = crPW;
		this.crName = crName;
		this.crNick = crNick;
		this.crPhone = crPhone;
		this.crBirth = crBirth;
		this.crGender = crGender;
		this.crPhoto = crPhoto;
		this.crIntro = crIntro;
		this.crBPhoto = crBPhoto;
		this.crDepart = crDepart;
		this.crField = crField;
		this.crCerti1 = crCerti1;
		this.crCerti2 = crCerti2;
		this.crCerti3 = crCerti3;
		this.crCerti4 = crCerti4;
		this.crCerti5 = crCerti5;
	}
	
	
	@Override
	public String toString() {
		return "Carry [crIDX=" + crIDX + ", email=" + email + ", crPW=" + crPW + ", crName=" + crName + ", crNick="
				+ crNick + ", crPhone=" + crPhone + ", crBirth=" + crBirth + ", crGender=" + crGender + ", crPhoto="
				+ crPhoto + ", crIntro=" + crIntro + ", crBPhoto=" + crBPhoto + ", crDepart=" + crDepart + ", crField="
				+ crField + ", crCerti1=" + crCerti1 + ", crCerti2=" + crCerti2 + ", crCerti3=" + crCerti3
				+ ", crCerti4=" + crCerti4 + ", crCerti5=" + crCerti5 + "]";
	}



}
