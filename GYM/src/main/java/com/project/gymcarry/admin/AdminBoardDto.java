package com.project.gymcarry.admin;

public class AdminBoardDto {

	private int adminidx;
	private String category;
	private int idx;
	private String title;
	private String content;
	private String date;
	
	// 기본 생성자
	public AdminBoardDto() {}

	
	public AdminBoardDto(int adminidx, String category, int idx, String title, String content, String date) {
		this.adminidx = adminidx;
		this.category = category;
		this.idx = idx;
		this.title = title;
		this.content = content;
		this.date = date;
	}

	
	
	public int getAdminidx() {
		return adminidx;
	}

	public void setAdminidx(int adminidx) {
		this.adminidx = adminidx;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
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
		return "AdminBoardDto [adminidx=" + adminidx + ", category=" + category + ", idx=" + idx + ", title=" + title
				+ ", content=" + content + ", date=" + date + "]";
	}
	
	
}
