package com.project.gymcarry.admin;

public class TermNoticeDto {

	private String title;
	private String content;
	private String date;
	
	// 기본 생성자
	public TermNoticeDto() {}

	public TermNoticeDto(String title, String content, String date) {
		this.title = title;
		this.content = content;
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	@Override
	public String toString() {
		return "TermNoticeDto [title=" + title + ", content=" + content + ", date=" + date + "]";
	}
	
	
	
}
