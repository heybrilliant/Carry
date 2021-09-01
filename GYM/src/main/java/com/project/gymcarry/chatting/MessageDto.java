package com.project.gymcarry.chatting;

public class MessageDto {
	private int chatidx;
	private String chatcontent;
	private int cridx;
	private int memidx;
	private int contenttype;
	private String crnick;
	private String memnick;
	private String chatdate;
	public MessageDto() {
		// TODO Auto-generated constructor stub
	}
	public MessageDto(int chatidx, String chatcontent, int cridx, int memidx, int contenttype, String crnick,
			String memnick, String chatdate) {
		super();
		this.chatidx = chatidx;
		this.chatcontent = chatcontent;
		this.cridx = cridx;
		this.memidx = memidx;
		this.contenttype = contenttype;
		this.crnick = crnick;
		this.memnick = memnick;
		this.chatdate = chatdate;
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
	public String getChatdate() {
		return chatdate;
	}
	public void setChatdate(String chatdate) {
		this.chatdate = chatdate;
	}
	@Override
	public String toString() {
		return "MessageDto [chatidx=" + chatidx + ", chatcontent=" + chatcontent + ", cridx=" + cridx + ", memidx="
				+ memidx + ", contenttype=" + contenttype + ", crnick=" + crnick + ", memnick=" + memnick
				+ ", chatdate=" + chatdate + "]";
	}
	
}
