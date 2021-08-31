package com.project.gymcarry.mypage;

public class MypageDto {

	private int infoidx;
	private int memidx;
	private String infotype;
	private String infocontens;
	private String infodate;

	@Override
	public String toString() {
		return "MypageDto [infoidx=" + infoidx + ", memidx=" + memidx + ", infotype=" + infotype + ", infocontens="
				+ infocontens + ", infodate=" + infodate + "]";
	}

	public MypageDto(int infoidx, int memidx, String infotype, String infocontens, String infodate) {
		super();
		this.infoidx = infoidx;
		this.memidx = memidx;
		this.infotype = infotype;
		this.infocontens = infocontens;
		this.infodate = infodate;
	}

	public int getInfoidx() {
		return infoidx;
	}

	public void setInfoidx(int infoidx) {
		this.infoidx = infoidx;
	}

	public int getMemidx() {
		return memidx;
	}

	public void setMemidx(int memidx) {
		this.memidx = memidx;
	}

	public String getInfotype() {
		return infotype;
	}

	public void setInfotype(String infotype) {
		this.infotype = infotype;
	}

	public String getInfocontens() {
		return infocontens;
	}

	public void setInfocontens(String infocontens) {
		this.infocontens = infocontens;
	}

	public String getInfodate() {
		return infodate;
	}

	public void setInfodate(String infodate) {
		this.infodate = infodate;
	}

}
