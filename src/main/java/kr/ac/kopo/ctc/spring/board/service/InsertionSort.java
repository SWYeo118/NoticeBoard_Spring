package kr.ac.kopo.ctc.spring.board.service;

import kr.ac.kopo.ctc.spring.board.web.sortingController.Sorter;

public class InsertionSort implements Sorter {

	@Override
	public void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j;
			for (j = i - 1; j >= 0; j--) {
				if (temp < arr[j])
					arr[j + 1] = arr[j];
				else
					break;
			}
			arr[j + 1] = temp;
		}

	}

}
