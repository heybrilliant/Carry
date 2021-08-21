package com.project.gymcarry.chatting;

public class CarryDtoTest {
	
	private int cridx;
	private String crnick;
	private String centername;
	
	public CarryDtoTest(int cridx, String crnick, String centername) {
		this.cridx = cridx;
		this.crnick = crnick;
		this.centername = centername;
	}
	public int getCridx() {
		return cridx;
	}
	public void setCridx(int cridx) {
		this.cridx = cridx;
	}
	public String getCrnick() {
		return crnick;
	}
	public void setCrnick(String crnick) {
		this.crnick = crnick;
	}
	public String getCentername() {
		return centername;
	}
	public void setCentername(String centername) {
		this.centername = centername;
	}
	
}
