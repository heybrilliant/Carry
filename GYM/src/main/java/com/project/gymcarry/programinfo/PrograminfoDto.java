package com.project.gymcarry.programinfo;

public class PrograminfoDto {
	
	private int proIDX;
	private int proPrice1;
	private int proPrice5;
	private int proPrice10;
	private int proPrice20;
	private int faceOrNot;
	
	
	public int getProIDX() {
		return proIDX;
	}
	public void setProIDX(int proIDX) {
		this.proIDX = proIDX;
	}
	public int getProPrice1() {
		return proPrice1;
	}
	public void setProPrice1(int proPrice1) {
		this.proPrice1 = proPrice1;
	}
	public int getProPrice5() {
		return proPrice5;
	}
	public void setProPrice5(int proPrice5) {
		this.proPrice5 = proPrice5;
	}
	public int getProPrice10() {
		return proPrice10;
	}
	public void setProPrice10(int proPrice10) {
		this.proPrice10 = proPrice10;
	}
	public int getProPrice20() {
		return proPrice20;
	}
	public void setProPrice20(int proPrice20) {
		this.proPrice20 = proPrice20;
	}
	public int getFaceOrNot() {
		return faceOrNot;
	}
	public void setFaceOrNot(int faceOrNot) {
		this.faceOrNot = faceOrNot;
	}
	
	
	
	public PrograminfoDto(int proIDX, int proPrice1, int proPrice5, int proPrice10, int proPrice20, int faceOrNot) {
		super();
		this.proIDX = proIDX;
		this.proPrice1 = proPrice1;
		this.proPrice5 = proPrice5;
		this.proPrice10 = proPrice10;
		this.proPrice20 = proPrice20;
		this.faceOrNot = faceOrNot;
	}
	
	
	
	@Override
	public String toString() {
		return "paymentDto [proIDX=" + proIDX + ", proPrice1=" + proPrice1 + ", proPrice5=" + proPrice5
				+ ", proPrice10=" + proPrice10 + ", proPrice20=" + proPrice20 + ", faceOrNot=" + faceOrNot + "]";
	}

	
	
}
