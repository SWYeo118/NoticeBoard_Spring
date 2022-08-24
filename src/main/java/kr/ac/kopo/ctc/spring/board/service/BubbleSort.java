package kr.ac.kopo.ctc.spring.board.service;

import kr.ac.kopo.ctc.spring.board.web.sortingService.Sorter;

public class BubbleSort implements Sorter {

	@Override
	public void sort(int[] arr) {
		final int size = arr.length;
		for (int i = 0; i < size; i++) {
			for (int m : arr) {
			System.out.println(m);
			}
			for (int j = i; j < size; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
