package com.project.gymcarry.chatroom;

public class Chat {
	
	private int chatid;
	private String chatcontent;
	
	
	public Chat(int chatid, String chatcontent) {
		this.chatid = chatid;
		this.chatcontent = chatcontent;
	}
	
	public int getChatid() {
		return chatid;
	}
	public void setChatid(int chatid) {
		this.chatid = chatid;
	}
	public String getChatcontent() {
		return chatcontent;
	}
	public void setChatcontent(String chatcontent) {
		this.chatcontent = chatcontent;
	}
	
	
}
