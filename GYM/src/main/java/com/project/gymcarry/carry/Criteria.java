package com.project.gymcarry.carry;

// 특정 페이지 조회를 위한 클래스
public class Criteria {

	private int page; // 현재 페이지 번호
	private int perPageNum; // 페이지당 보여줄 리뷰의 수
	
	
	public int getPageStart() {
		// 특정 페이지의 범위를 정하는 구간
		// 현재 페이지의 리뷰글 시작 번호
		// 0~4, 4~8 이런 식으로
		return (this.page-1) * perPageNum;
	}
	
	
	public Criteria() {
		// 기본 생성자 
		// 최초 페이지 진입시 필요한 기본값 세팅
		this.page = 1; // 페이지 번호 1
		this.perPageNum = 5; // 한 페이지당 5개의 리뷰
	}
	
	// 현재 페이지 번호 page : getter/setter
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		// 현재 페이지 번호가 0보다 작거나 같을시엔 페이지번호를 1로 세팅한다.
		if(page <= 0) {
			this.page = 1;
		} else {
			this.page = page;
		}
	}
	
	
	// 페이지당 보여줄 리뷰의 개수  perPageNum : getter/setter 세팅
	public int getPerPageNum() {
		return perPageNum;
	}
	
	public void setPerPageNum(int perPageNum) {
		int cnt = this.perPageNum;
		
		if(perPageNum != cnt) {
			this.perPageNum = cnt;
		} else {
			this.perPageNum = perPageNum;
		}
		
	}


	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
	
	
}
