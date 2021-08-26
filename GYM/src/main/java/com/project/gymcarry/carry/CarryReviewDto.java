package com.project.gymcarry.carry;

public class CarryReviewDto {
	
	private int reviewidx;
	private String reviewcontent;
	private int cridx;
	private int memidx;
	private String memnick;
	
	
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
	
	
	public CarryReviewDto(int reviewidx, String reviewcontent, int cridx, int memidx, String memnick) {
		this.reviewidx = reviewidx;
		this.reviewcontent = reviewcontent;
		this.cridx = cridx;
		this.memidx = memidx;
		this.memnick = memnick;
	}
	
	
	@Override
	public String toString() {
		return "CarryReviewDto [reviewidx=" + reviewidx + ", reviewcontent=" + reviewcontent + ", cridx=" + cridx
				+ ", memidx=" + memidx + ", memnick=" + memnick + "]";
	}
	
	
	
}
