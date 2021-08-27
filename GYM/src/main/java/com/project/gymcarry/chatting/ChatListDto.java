package com.project.gymcarry.chatting;

import java.sql.Timestamp;

public class ChatListDto {
	
	private int chatidx;
	private int cridx;
	private int memidx;
	private String crnick;
	private String placename;
	private Timestamp chatdate;
	private String chatcontent;
	private int chatread;
	public ChatListDto() {
	}
	public ChatListDto(int chatidx, int cridx, int memidx, String crnick, String placename, Timestamp chatdate,
			String chatcontent, int chatread) {
		this.chatidx = chatidx;
		this.cridx = cridx;
		this.memidx = memidx;
		this.crnick = crnick;
		this.placename = placename;
		this.chatdate = chatdate;
		this.chatcontent = chatcontent;
		this.chatread = chatread;
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
	public String getPlacename() {
		return placename;
	}
	public void setPlacename(String placename) {
		this.placename = placename;
	}
	public Timestamp getChatdate() {
		return chatdate;
	}
	public void setChatdate(Timestamp chatdate) {
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
	@Override
	public String toString() {
		return "ChatListDto [chatidx=" + chatidx + ", cridx=" + cridx + ", memidx=" + memidx + ", crnick=" + crnick
				+ ", placename=" + placename + ", chatdate=" + chatdate + ", chatcontent=" + chatcontent + ", chatread="
				+ chatread + "]";
	}
	
}
