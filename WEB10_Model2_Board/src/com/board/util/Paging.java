package com.board.util;

public class Paging {

	private int page = 1; //현재화면에 표시할 페이지 번호
	private int totalCount; //전체 게시글의 수
	
	private int displayRow = 10; //한 페이지에 표시할 게시글 수 
	private int displayPage = 10; // 이전◀ 다음▶ 버튼 사이에 몇개의 페이지를 표시할지
	
	private int beginPage; //표시될 시작페이지 번호 1 / 11 / 21 ...
	private int endPage; //표시될 끝 페이지 번호 10 / 20 / 30 ...
	
	private boolean prev; //이전 버튼이 보일지 말지
	private boolean next; //다음 버튼이 보일지 말지 
	
	private int startNum; //현재 페이지에 표시될 게시물 번호의 시작
	private int endNum; //현재 페이지에 표시될 게시물 번호의 끝
	
	private void paging() {
		//각 멤버 변수 값 세팅
		
	
		double temp = Math.ceil(page/(double)displayPage);
		endPage = (int)(temp * displayPage);
		beginPage = endPage - displayPage + 1 ;
		
		int totalPage = (int)Math.ceil(totalCount/(displayRow));
		//총 게시물 수를 한 화면에 표시할 게시물 수로 나눠서 총 페이지 갯수를 계산
		
		if(totalPage < endPage) {//총 페이지가 화면에 표시할 끝페이지보다 작다면
			endPage = totalPage;
			next = false;
		} else {
			next = true;
		}
		
		prev = (beginPage==1)? false:true;
		
		startNum = (page-1)*displayRow+1;
		//현재 화면의 시작 게시물 번호 : 1페이지-1, 2페이지-11, 3페이지-21 ...
		endNum = page*displayRow;
	}
	
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getEndNum() {
		return endNum;
	}
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		paging(); //멤버메서드 호출 -> 각 멤버 변수 구성요소를 계산해주는 메서드
	}
	public int getDisplayRow() {
		return displayRow;
	}
	public void setDisplayRow(int displayRow) {
		this.displayRow = displayRow;
	}
	public int getDisplayPage() {
		return displayPage;
	}
	public void setDisplayPage(int displayPage) {
		this.displayPage = displayPage;
	}
	public int getBeginPage() {
		return beginPage;
	}
	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
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
	
	
}
