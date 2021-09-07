package com.project.gymcarry.chatting;

import java.sql.Timestamp;

public class ChatListDto {
	
	private int chatidx;
	private int cridx;
	private int memidx;
	private String crnick;
	private String memnick;
	private String placename;
	private String chatdate;
	private String chatcontent;
	private int chatread;
	private int messageidx;
	private int chatinoutidx;
	private int memposition;
	private int carryposition;
	private Timestamp outdate;
	public ChatListDto() {
	}
	
	public ChatListDto(int chatidx, int cridx, int memidx, String crnick, String memnick, String placename,
			String chatdate, String chatcontent, int chatread, int messageidx, int chatinoutidx, int memposition,
			int carryposition, Timestamp outdate) {
		this.chatidx = chatidx;
		this.cridx = cridx;
		this.memidx = memidx;
		this.crnick = crnick;
		this.memnick = memnick;
		this.placename = placename;
		this.chatdate = chatdate;
		this.chatcontent = chatcontent;
		this.chatread = chatread;
		this.messageidx = messageidx;
		this.chatinoutidx = chatinoutidx;
		this.memposition = memposition;
		this.carryposition = carryposition;
		this.outdate = outdate;
	}

	public int getChatidx() {
		return chatidx;
	}
	public void setChatidx(int chatidx) {
		this.chatidx = chatidx;
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
	public String getCrnick() {
		return crnick;
	}
	public void setCrnick(String crnick) {
		this.crnick = crnick;
	}
	public String getMemnick() {
		return memnick;
	}
	public void setMemnick(String memnick) {
		this.memnick = memnick;
	}
	public String getPlacename() {
		return placename;
	}
	public void setPlacename(String placename) {
		this.placename = placename;
	}
	public String getChatdate() {
		return chatdate;
	}
	public void setChatdate(String chatdate) {
		this.chatdate = chatdate;
	}
	public String getChatcontent() {
		return chatcontent;
	}
	public void setChatcontent(String chatcontent) {
		this.chatcontent = chatcontent;
	}
	public int getChatread() {
		return chatread;
	}
	public void setChatread(int chatread) {
		this.chatread = chatread;
	}
	public int getMessageidx() {
		return messageidx;
	}
	public void setMessageidx(int messageidx) {
		this.messageidx = messageidx;
	}
	public int getMemposition() {
		return memposition;
	}
	public void setMemposition(int memposition) {
		this.memposition = memposition;
	}
	public int getCarryposition() {
		return carryposition;
	}
	public void setCarryposition(int carryposition) {
		this.carryposition = carryposition;
	}
	public Timestamp getOutdate() {
		return outdate;
	}
	public void setOutdate(Timestamp outdate) {
		this.outdate = outdate;
	}
	
	public int getChatinoutidx() {
		return chatinoutidx;
	}

	public void setChatinoutidx(int chatinoutidx) {
		this.chatinoutidx = chatinoutidx;
	}

	@Override
	public String toString() {
		return "ChatListDto [chatidx=" + chatidx + ", cridx=" + cridx + ", memidx=" + memidx + ", crnick=" + crnick
				+ ", memnick=" + memnick + ", placename=" + placename + ", chatdate=" + chatdate + ", chatcontent="
				+ chatcontent + ", chatread=" + chatread + ", messageidx=" + messageidx + ", chatinoutidx="
				+ chatinoutidx + ", memposition=" + memposition + ", carryposition=" + carryposition + ", outdate="
				+ outdate + "]";
	}
	
}
