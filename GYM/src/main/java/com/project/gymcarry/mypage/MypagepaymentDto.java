package com.project.gymcarry.mypage;

import java.time.LocalDateTime;
import java.util.Date;

public class MypagepaymentDto {

	private String payname;
	private int paynum;
	private String paydate;
	private int payprice;

	public String getPayname() {
		return payname;
	}

	public void setPayname(String payname) {
		this.payname = payname;
	}

	public int getPaynum() {
		return paynum;
	}

	public void setPaynum(int paynum) {
		this.paynum = paynum;
	}

	public String getPaydate() {
		return paydate;
	}

	public void setPaydate(String paydate) {
		this.paydate = paydate;
	}

	public int getPayprice() {
		return payprice;
	}

	public void setPayprice(int payprice) {
		this.payprice = payprice;
	}

	@Override
	public String toString() {
		return "MypagepaymentDto [payname=" + payname + ", paynum=" + paynum + ", paydate=" + paydate + ", payprice="
				+ payprice + "]";
	}

	public MypagepaymentDto() {

	}

}
