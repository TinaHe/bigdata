package com.insigma.util;

public class Page {
	//��ҳ��
	private int totalPageCount;
	//��ǰҳ��
	private int pageNow;
	//��ʼλ��
	private int startPos;
	//ÿҳ����
	private int pageSize = 20;
	//������
	private int totalNum;
	
	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public Page(int totalNum,int pageNow) {
		this.totalNum = totalNum;
		this.pageNow = pageNow;
	}
	
	public int getTotalPageCount() {
		return totalNum/pageSize + 1;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getStartPos() {
		return pageNow * pageSize + 1;
	}
	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
