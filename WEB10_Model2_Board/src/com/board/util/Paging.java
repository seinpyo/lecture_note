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
