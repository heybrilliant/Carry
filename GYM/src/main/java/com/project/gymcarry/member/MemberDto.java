package com.project.gymcarry.member;

public class MemberDto {
	private int memidx;
	private String mememail;
	private String mempw;
	private String memname;
	private String memnick;
	public MemberDto() {
	}
	public MemberDto(int memidx, String mememail, String mempw, String memname, String memnick) {
		super();
		this.memidx = memidx;
		this.mememail = mememail;
		this.mempw = mempw;
		this.memname = memname;
		this.memnick = memnick;
	}
	public int getMemidx() {
		return memidx;
	}
	public void setMemidx(int memidx) {
		this.memidx = memidx;
	}
	public String getMememail() {
		return mememail;
	}
	public void setMememail(String mememail) {
		this.mememail = mememail;
	}
	public String getMempw() {
		return mempw;
	}
	public void setMempw(String mempw) {
		this.mempw = mempw;
	}
	public String getMemname() {
		return memname;
	}
	public void setMemname(String memname) {
		this.memname = memname;
	}
	public String getMemnick() {
		return memnick;
	}
	public void setMemnick(String memnick) {
		this.memnick = memnick;
	}
	@Override
	public String toString() {
		return "MemberDto [memidx=" + memidx + ", mememail=" + mememail + ", mempw=" + mempw + ", memname=" + memname
				+ ", memnick=" + memnick + "]";
	}
	
}
