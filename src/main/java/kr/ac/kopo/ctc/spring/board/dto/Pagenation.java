package kr.ac.kopo.ctc.spring.board.dto;

public class Pagenation {
	private int ppPage;
	private int pPage;
	private int nPage;
	private int nnPage;
	private int cPage;
	private int countPerPage;
	private int pageSize;
	private int totalCount;
	public int getPpPage() {
		return ppPage;
	}
	public void setPpPage(int ppPage) {
		this.ppPage = ppPage;
	}
	public int getpPage() {
		return pPage;
	}
	public void setpPage(int pPage) {
		this.pPage = pPage;
	}
	public int getnPage() {
		return nPage;
	}
	public void setnPage(int nPage) {
		this.nPage = nPage;
	}
	public int getNnPage() {
		return nnPage;
	}
	public void setNnPage(int nnPage) {
		this.nnPage = nnPage;
	}
	public int getcPage() {
		return cPage;
	}
	public void setcPage(int cPage) {
		this.cPage = cPage;
	}
	public int getCountPerPage() {
		return countPerPage;
	}
	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
}
