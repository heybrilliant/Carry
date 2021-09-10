package com.project.gymcarry.carry;

public class CarryReviewDto {
	
	private int reviewidx;
	private String reviewdate;
	private String reviewcontent;
	private int cridx;
	private int memidx;
	private String memnick;
	// @JsonFormat(pattern = "HH:mm a", timezone = "Asia/Seoul")
	
	public CarryReviewDto() {}
	
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
	
	public String getReviewdate() {
		return reviewdate;
	}

	public void setReviewdate(String reviewdate) {
		this.reviewdate = reviewdate;
	}

	
	
	public CarryReviewDto(int reviewidx, String reviewcontent, int cridx, int memidx, String memnick,
			String reviewdate) {
		this.reviewidx = reviewidx;
		this.reviewcontent = reviewcontent;
		this.cridx = cridx;
		this.memidx = memidx;
		this.memnick = memnick;
		this.reviewdate = reviewdate;
	}

	
	@Override
	public String toString() {
		return "CarryReviewDto [reviewidx=" + reviewidx + ", reviewcontent=" + reviewcontent + ", cridx=" + cridx
				+ ", memidx=" + memidx + ", memnick=" + memnick + ", reviewdate=" + reviewdate + "]";
	}

	
	
}
