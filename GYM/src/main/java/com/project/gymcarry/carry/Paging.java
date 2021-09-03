package com.project.gymcarry.carry;

// 게시판 하단의 페이징 처리
public class Paging {

	private int totalCount; // 한 캐리당 전체 리뷰 개수
	private int displayPageNum = 5; // 페이지에서 한번에 보여질 페이지 번호의 개수
	
	private int startPage; // 화면의 시작 번호
	private int endPage; // 화면의 끝 번호
	private boolean prev; // 페이징 이전 버튼 활성화 여부
	private boolean next; // 페이징 다음 버튼 활성화 여부
	
	private Criteria cri;
	
	
	public int getTotalCount() {
		return totalCount;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		pagingData();
	}
	
	
	private void pagingData() {
		
		// endPage = (현재 페이지 번호 / 화면에 보여질 페이지 번호의 개수) * 화면에 보여질 페이지 번호의 개수
		endPage = (int)(Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);
		// startPage = (끝 페이지 번호 - 화면에 보여질 페이지 번호의 개수) + 1
		startPage = (endPage - displayPageNum) + 1;

		int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		// tempEndPage : 마지막 페이지 번호 = 총 게시글 수 / 한 페이지당 보여줄 게시글의 수
		
		prev = startPage == 1 ? false : true;
		// 이전 버튼 생성 여부 = 시작페이지 번호가 1과 같으면 false / 아니면 true 값
		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
		// 다음 버튼 생성 여부 = 끝 페이지 번호 * 한 페이지당 보여줄 게시글의 수가 
		// 총 게시글의 수보다 크거나 같다면 false / 아니면 true
		
	}

	
	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	
	@Override
	public String toString() {
		return "paging [totalCount=" + totalCount + ", displayPageNum=" + displayPageNum + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", prev=" + prev + ", next=" + next + ", cri=" + cri + "]";
	}

	
	
	/*
	 * 
	 * displayPageNum :
	 * 이 부분에 대한 설정이 하단 페이징 넘버 1 2 .. 5 를 결정한다.
	 * 내가 5로 설정했으니 [1 ~ 5 다음] 까지만 하단에 나오고,
	 * 5페이지 이후부터는 [이전 5 ~ 9 다음] 이런식으로 출력되게 된다.
	 * 
	 */

	
}