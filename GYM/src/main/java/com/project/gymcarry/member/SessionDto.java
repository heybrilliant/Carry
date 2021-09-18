package com.project.gymcarry.member;

public class SessionDto {
	private int memidx;
	private String memname;
	private String memnick;
	private String mememail;
	private int cridx;
	private String crname;
	private String crnick;
	public SessionDto() {
	}
	public SessionDto(int memidx, String memname, String memnick, String mememail, int cridx, String crname,
			String crnick) {
		super();
		this.memidx = memidx;
		this.memname = memname;
		this.memnick = memnick;
		this.mememail = mememail;
		this.cridx = cridx;
		this.crname = crname;
		this.crnick = crnick;
	}
	public int getMemidx() {
		return memidx;
	}
	public void setMemidx(int memidx) {
		this.memidx = memidx;
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
	public String getMememail() {
		return mememail;
	}
	public void setMememail(String mememail) {
		this.mememail = mememail;
	}
	public int getCridx() {
		return cridx;
	}
	public void setCridx(int cridx) {
		this.cridx = cridx;
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

}