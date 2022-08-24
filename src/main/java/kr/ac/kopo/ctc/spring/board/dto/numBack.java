package kr.ac.kopo.ctc.spring.board.dto;

import kr.ac.kopo.ctc.spring.board.web.sortingService.Sorter;

public class numBack {
	public long time1;
	public long time2;
	public int[] arrIntCompare;
	public Sorter BubbleSort;
	public Sorter InsertionSort;
	
	public long getTime1() {
		return time1;
	}
	public void setTime1(long time1) {
		this.time1 = time1;
	}
	public long getTime2() {
		return time2;
	}
	public void setTime2(long time2) {
		this.time2 = time2;
	}
	public int[] getArrIntCompare() {
		return arrIntCompare;
	}
	public void setArrIntCompare(int[] arrIntCompare) {
		this.arrIntCompare = arrIntCompare;
	}
	public Sorter getBubbleSort() {
		return BubbleSort;
	}
	public void setBubbleSort(Sorter bubbleSort) {
		BubbleSort = bubbleSort;
	}
}
