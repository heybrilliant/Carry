package com.project.gymcarry.carry;

public class CarryPriceDto {
	
	private int cridx;
	private int proprice1;
	private int proprice5;
	private int proprice10;
	private int proprice20;
	
	// 기본 생성자
	public CarryPriceDto() {}
	
	
	public CarryPriceDto(int cridx, int proprice1, int proprice5, int proprice10, int proprice20) {
		this.cridx = cridx;
		this.proprice1 = proprice1;
		this.proprice5 = proprice5;
		this.proprice10 = proprice10;
		this.proprice20 = proprice20;
	}
	
	
	public int getCridx() {
		return cridx;
	}
	public void setCridx(int cridx) {
		this.cridx = cridx;
	}
	public int getProprice1() {
		return proprice1;
	}
	public void setProprice1(int proprice1) {
		this.proprice1 = proprice1;
	}
	public int getProprice5() {
		return proprice5;
	}
	public void setProprice5(int proprice5) {
		this.proprice5 = proprice5;
	}
	public int getProprice10() {
		return proprice10;
	}
	public void setProprice10(int proprice10) {
		this.proprice10 = proprice10;
	}
	public int getProprice20() {
		return proprice20;
	}
	public void setProprice20(int proprice20) {
		this.proprice20 = proprice20;
	}
	
	
	@Override
	public String toString() {
		return "CarryPriceDto [cridx=" + cridx + ", proprice1=" + proprice1 + ", proprice5=" + proprice5
				+ ", proprice10=" + proprice10 + ", proprice20=" + proprice20 + "]";
	}

	
	
}
