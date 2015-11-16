package com.jpark.restful.util;


public class Paging {
	public int totalNum;
	public int totalBlock;
	public int countPerPage;
	public int pagePerScreen;
	public int maxPage;
	public int pageNum;
	public int blockNum;
	public int startNum;
	public int endNum;
	public int RStartNum;
	public int REndNum;
	public int beforePage;
	public int nextPage;
	
	public Paging(int totalSize, int pageSeq){
		totalNum = totalSize;
		countPerPage = 6;
		pagePerScreen = 10;
		pageNum = pageSeq;
		startNum =  pageNum % pagePerScreen == 0 ? (pageNum / pagePerScreen -1) * pagePerScreen + 1 : (pageNum / pagePerScreen) * pagePerScreen + 1;
		endNum = startNum + pagePerScreen -1;
		RStartNum = ( countPerPage * (pageNum-1)) + 1;
		REndNum = countPerPage * pageNum;
		blockNum = endNum/pagePerScreen;
		maxPage = totalNum%countPerPage == 0 ? totalNum/countPerPage : (totalNum/countPerPage) + 1;
		totalBlock = maxPage%pagePerScreen==0 ? (int)Math.ceil(maxPage/pagePerScreen) : (int)Math.ceil(maxPage/pagePerScreen)+1;
		beforePage = startNum-1;
		nextPage = endNum+1;
	}
	public Paging(int totalSize, int pageSeq, int countPerPage){
		totalNum = totalSize;
		pagePerScreen = 10;
		pageNum = pageSeq;
		startNum =  pageNum % pagePerScreen == 0 ? (pageNum / pagePerScreen -1) * pagePerScreen + 1 : (pageNum / pagePerScreen) * pagePerScreen + 1;
		endNum = startNum + pagePerScreen -1;
		RStartNum = ( countPerPage * (pageNum-1)) + 1;
		REndNum = countPerPage * pageNum;
		blockNum = endNum/pagePerScreen;
		maxPage = totalNum%countPerPage == 0 ? totalNum/countPerPage : (totalNum/countPerPage) + 1;
		totalBlock = maxPage%pagePerScreen==0 ? (int)Math.ceil(maxPage/pagePerScreen) : (int)Math.ceil(maxPage/pagePerScreen)+1;
		beforePage = startNum-1;
		nextPage = endNum+1;
	}
	
	public Paging(int totalSize, int pageSeq, int countPerPage, int pagePerScreen){
		totalNum = totalSize;
		pageNum = pageSeq;
		startNum =  pageNum % pagePerScreen == 0 ? (pageNum / pagePerScreen -1) * pagePerScreen + 1 : (pageNum / pagePerScreen) * pagePerScreen + 1;
		endNum = startNum + pagePerScreen -1;
		RStartNum = ( countPerPage * (pageNum-1)) + 1;
		REndNum = countPerPage * pageNum;
		blockNum = endNum/pagePerScreen;
		maxPage = totalNum%countPerPage == 0 ? totalNum/countPerPage : (totalNum/countPerPage) + 1;
		totalBlock = maxPage%pagePerScreen==0 ? (int)Math.ceil(maxPage/pagePerScreen) : (int)Math.ceil(maxPage/pagePerScreen)+1;
		beforePage = startNum-1;
		nextPage = endNum+1;
	}
}
