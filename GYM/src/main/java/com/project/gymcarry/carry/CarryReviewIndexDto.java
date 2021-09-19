package com.project.gymcarry.carry;

public class CarryReviewIndexDto {
	
	private int reviewidx;
	private String reviewcontent;
	private int cridx;
	private String crphoto;
	private String crname;
	// 기본 생성자
	public CarryReviewIndexDto() {}
	public CarryReviewIndexDto(int reviewidx, String reviewcontent, int cridx, String crphoto, String crname) {
		super();
		this.reviewidx = reviewidx;
		this.reviewcontent = reviewcontent;
		this.cridx = cridx;
		this.crphoto = crphoto;
		this.crname = crname;
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
	public int getCridx() {
		return cridx;
	}
	public void setCridx(int cridx) {
		this.cridx = cridx;
	}
	public String getCrphoto() {
		return crphoto;
	}
	public void setCrphoto(String crphoto) {
		this.crphoto = crphoto;
	}
	public String getCrname() {
		return crname;
	}
	public void setCrname(String crname) {
		this.crname = crname;
	}
	@Override
	public String toString() {
		return "CarryReviewIndexDto [reviewidx=" + reviewidx + ", reviewcontent=" + reviewcontent + ", cridx=" + cridx
				+ ", crphoto=" + crphoto + ", crname=" + crname + "]";
	}

	
	
	
	
	
}
