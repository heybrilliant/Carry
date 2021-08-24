package com.project.gymcarry.carryreview;

public class CarryReviewDto {

	private int reviewIDX;
	private String reviewContent;
	private int crIDX;
	private int memIDX;
	
	
	public int getReviewIDX() {
		return reviewIDX;
	}
	public void setReviewIDX(int reviewIDX) {
		this.reviewIDX = reviewIDX;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public int getCrIDX() {
		return crIDX;
	}
	public void setCrIDX(int crIDX) {
		this.crIDX = crIDX;
	}
	public int getMemIDX() {
		return memIDX;
	}
	public void setMemIDX(int memIDX) {
		this.memIDX = memIDX;
	}
	
	
	@Override
	public String toString() {
		return "ReviewDto [reviewIDX=" + reviewIDX + ", reviewContent=" + reviewContent + ", crIDX=" + crIDX
				+ ", memIDX=" + memIDX + "]";
	}
	
	
	
	public CarryReviewDto(int reviewIDX, String reviewContent, int crIDX, int memIDX) {
		super();
		this.reviewIDX = reviewIDX;
		this.reviewContent = reviewContent;
		this.crIDX = crIDX;
		this.memIDX = memIDX;
	}
	

	
}
