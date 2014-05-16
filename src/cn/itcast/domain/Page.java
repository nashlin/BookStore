package cn.itcast.domain;

import java.util.List;

public class Page {

	private int currentPage;
	private int totalRecord;
	private int pageSize=3;
	private int totalPage;
	private int startIndex;
	private List<Book> list;
	
	public Page(int currentPage,int totalRecord){
		this.currentPage=currentPage;
		this.totalRecord=totalRecord;
		this.totalPage=(totalRecord%pageSize==0?(totalRecord/pageSize):(totalRecord/pageSize+1));
		this.startIndex=(currentPage-1)*pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}
}
