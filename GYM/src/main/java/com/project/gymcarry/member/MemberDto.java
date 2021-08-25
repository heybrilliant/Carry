package com.project.gymcarry.member;

public class MemberDto {
	private int memidx;
	private String mememail;
	private String mempw;
	private String memname;
	private String memnick;
	private String memphone;
	private int membirth;
	private String memgender;
	public MemberDto() {
	}
	public MemberDto(int memidx, String mememail, String mempw, String memname, String memnick, String memphone,
			int membirth, String memgender) {
		super();
		this.memidx = memidx;
		this.mememail = mememail;
		this.mempw = mempw;
		this.memname = memname;
		this.memnick = memnick;
		this.memphone = memphone;
		this.membirth = membirth;
		this.memgender = memgender;
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
	public String getMemphone() {
		return memphone;
	}
	public void setMemphone(String memphone) {
		this.memphone = memphone;
	}
	public int getMembirth() {
		return membirth;
	}
	public void setMembirth(int membirth) {
		this.membirth = membirth;
	}
	public String getMemgender() {
		return memgender;
	}
	public void setMemgender(String memgender) {
		this.memgender = memgender;
	}
	@Override
	public String toString() {
		return "MemberDto [memidx=" + memidx + ", mememail=" + mememail + ", mempw=" + mempw + ", memname=" + memname
				+ ", memnick=" + memnick + ", memphone=" + memphone + ", membirth=" + membirth + ", memgender="
				+ memgender + "]";
	}
	
}
