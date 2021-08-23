package com.project.gymcarry.chatting;


import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;


public class ChatRoomDto {
	
	private int messageidx; 		//메세지번호
	private int chatidx;			//채팅방번호
	private String chatcontent;		//대화내용
	@JsonFormat(pattern = "HH:mm a")
	private Timestamp chatdate;		//대화시간
	private int cridx;				//캐리번호
	private int memidx;				//회원번호
	public ChatRoomDto() {
	}
	public ChatRoomDto(int messageidx, int chatidx, String chatcontent, Timestamp chatdate, int cridx, int memidx) {
		this.messageidx = messageidx;
		this.chatidx = chatidx;
		this.chatcontent = chatcontent;
		this.chatdate = chatdate;
		this.cridx = cridx;
		this.memidx = memidx;
	}
	
	public int getMessageidx() {
		return messageidx;
	}
	public void setMessageidx(int messageidx) {
		this.messageidx = messageidx;
	}
	public int getChatidx() {
		return chatidx;
	}
	public void setChatidx(int chatidx) {
		this.chatidx = chatidx;
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
	@Override
	public String toString() {
		return "ChatDto [messageidx=" + messageidx + ", chatidx=" + chatidx + ", chatcontent=" + chatcontent
				+ ", chatdate=" + chatdate + ", cridx=" + cridx + ", memidx=" + memidx + "]";
	}	
}
