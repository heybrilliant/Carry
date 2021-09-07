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
	private int contenttype;		//유저,캐리 대화내용 비교
	private int memposition;		//멤버 방나감안나감
	private int carryposition;		//캐리 방나감안나감
	private int chatread;			//읽음 안읽음 여부
	private int likecheck;			//하트여부			
	public ChatRoomDto() {
	}
	public ChatRoomDto(int messageidx, int chatidx, String chatcontent, Timestamp chatdate, int cridx, int memidx,
			int contenttype, int memposition, int carryposition, int chatread, int likecheck) {
		super();
		this.messageidx = messageidx;
		this.chatidx = chatidx;
		this.chatcontent = chatcontent;
		this.chatdate = chatdate;
		this.cridx = cridx;
		this.memidx = memidx;
		this.contenttype = contenttype;
		this.memposition = memposition;
		this.carryposition = carryposition;
		this.chatread = chatread;
		this.likecheck = likecheck;
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
	public int getContenttype() {
		return contenttype;
	}
	public void setContenttype(int contenttype) {
		this.contenttype = contenttype;
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
	public int getChatread() {
		return chatread;
	}
	public void setChatread(int chatread) {
		this.chatread = chatread;
	}
	public int getLikecheck() {
		return likecheck;
	}
	public void setLikecheck(int likecheck) {
		this.likecheck = likecheck;
	}
	@Override
	public String toString() {
		return "ChatRoomDto [messageidx=" + messageidx + ", chatidx=" + chatidx + ", chatcontent=" + chatcontent
				+ ", chatdate=" + chatdate + ", cridx=" + cridx + ", memidx=" + memidx + ", contenttype=" + contenttype
				+ ", memposition=" + memposition + ", carryposition=" + carryposition + ", chatread=" + chatread
				+ ", likecheck=" + likecheck + "]";
	}
	
}
