package com.project.gymcarry.chatting;

public class ChatListDto {
	
	private int chatidx;
	private String crnick;
	private String centername;
	private String chatcontent;
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
	@Override
	public String toString() {
		return "ChatListDto [chatidx=" + chatidx + ", crnick=" + crnick + ", centername=" + centername
				+ ", chatcontent=" + chatcontent + "]";
	}
}
