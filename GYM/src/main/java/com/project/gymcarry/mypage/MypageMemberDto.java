package com.project.gymcarry.mypage;

public class MypageMemberDto {

	private String MEMPHOTO;
	private String MEMNAME;
	private String MEMEMAIL;
	private String MEMPW;
	private String MEMNICK;
	private String MEMPHONE;
	private String MEMBIRTH;

	public String getMEMPHOTO() {
		return MEMPHOTO;
	}

	public void setMEMPHOTO(String mEMPHOTO) {
		MEMPHOTO = mEMPHOTO;
	}

	public String getMEMNAME() {
		return MEMNAME;
	}

	public void setMEMNAME(String mEMNAME) {
		MEMNAME = mEMNAME;
	}

	public String getMEMEMAIL() {
		return MEMEMAIL;
	}

	public void setMEMEMAIL(String mEMEMAIL) {
		MEMEMAIL = mEMEMAIL;
	}

	public String getMEMPW() {
		return MEMPW;
	}

	public void setMEMPW(String mEMPW) {
		MEMPW = mEMPW;
	}

	public String getMEMNICK() {
		return MEMNICK;
	}

	public void setMEMNICK(String mEMNICK) {
		MEMNICK = mEMNICK;
	}

	public String getMEMPHONE() {
		return MEMPHONE;
	}

	public void setMEMPHONE(String mEMPHONE) {
		MEMPHONE = mEMPHONE;
	}

	public String getMEMBIRTH() {
		return MEMBIRTH;
	}

	public void setMEMBIRTH(String mEMBIRTH) {
		MEMBIRTH = mEMBIRTH;
	}

	@Override
	public String toString() {
		return "MypageMemberDto [MEMPHOTO=" + MEMPHOTO + ", MEMNAME=" + MEMNAME + ", MEMEMAIL=" + MEMEMAIL + ", MEMPW="
				+ MEMPW + ", MEMNICK=" + MEMNICK + ", MEMPHONE=" + MEMPHONE + ", MEMBIRTH=" + MEMBIRTH + "]";
	}

	public MypageMemberDto(String mEMPHOTO, String mEMNAME, String mEMEMAIL, String mEMPW, String mEMNICK,
			String mEMPHONE, String mEMBIRTH) {
		super();
		MEMPHOTO = mEMPHOTO;
		MEMNAME = mEMNAME;
		MEMEMAIL = mEMEMAIL;
		MEMPW = mEMPW;
		MEMNICK = mEMNICK;
		MEMPHONE = mEMPHONE;
		MEMBIRTH = mEMBIRTH;
	}

}
