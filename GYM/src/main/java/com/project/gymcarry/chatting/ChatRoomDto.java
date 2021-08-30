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
	private int chatposition;		//방에서나감 안나감여부
	private int chatread;			//읽음 안읽음 여부
	private int chatlike;			//0좋아요x 1좋아요o
	private String crnick;	
	private String memnick;
	public ChatRoomDto() {
	}
	public ChatRoomDto(int messageidx, int chatidx, String chatcontent, Timestamp chatdate, int cridx, int memidx,
			int contenttype, int chatposition, int chatread, int chatlike, String crnick, String memnick) {
		super();
		this.messageidx = messageidx;
		this.chatidx = chatidx;
		this.chatcontent = chatcontent;
		this.chatdate = chatdate;
		this.cridx = cridx;
		this.memidx = memidx;
		this.contenttype = contenttype;
		this.chatposition = chatposition;
		this.chatread = chatread;
		this.chatlike = chatlike;
		this.crnick = crnick;
		this.memnick = memnick;
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
	public int getChatposition() {
		return chatposition;
	}
	public void setChatposition(int chatposition) {
		this.chatposition = chatposition;
	}
	public int getChatread() {
		return chatread;
	}
	public void setChatread(int chatread) {
		this.chatread = chatread;
	}
	public int getChatlike() {
		return chatlike;
	}
	public void setChatlike(int chatlike) {
		this.chatlike = chatlike;
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
	@Override
	public String toString() {
		return "ChatRoomDto [messageidx=" + messageidx + ", chatidx=" + chatidx + ", chatcontent=" + chatcontent
				+ ", chatdate=" + chatdate + ", cridx=" + cridx + ", memidx=" + memidx + ", contenttype=" + contenttype
				+ ", chatposition=" + chatposition + ", chatread=" + chatread + ", chatlike=" + chatlike + ", crnick="
				+ crnick + ", memnick=" + memnick + "]";
	}
	
}
