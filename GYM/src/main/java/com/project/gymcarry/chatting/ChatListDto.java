package com.project.gymcarry.chatting;


import java.sql.Timestamp;
import java.util.Date;


public class ChatListDto {
	
	private int chatidx;
	private String crnick;
	private String centername;
	private String chatcontent;
	private Timestamp chatdate;
	public int getChatidx() {
		return chatidx;
	}
	public void setChatidx(int chatidx) {
		this.chatidx = chatidx;
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
	public String getChatcontent() {
		return chatcontent;
	}
	public void setChatcontent(String chatcontent) {
		this.chatcontent = chatcontent;
	}
	public Timestamp getChatdate() {
		return chatdate;
	}
	public void setChatdate(Timestamp chatdate) {
		this.chatdate = chatdate;
	}
	public Date getDate() {
		return new Date(getChatdate().getTime());
	}	

}
