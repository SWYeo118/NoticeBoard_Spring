package kr.ac.kopo.ctc.spring.board.web;

import java.util.Arrays;

import kr.ac.kopo.ctc.spring.board.service.BubbleSort;
import kr.ac.kopo.ctc.spring.board.service.InsertionSort;
import kr.ac.kopo.ctc.spring.board.service.SelectionSort;

public class sortingController {

	public static void main(String[] args) {

		// 총 배열의 길이 미리 정하기
		final int SIZE = 30000;

		// 정렬 알고리즘 선택
		Sorter sorter = new BubbleSort();

		// 각각 다른 방식으로 정렬할 두개의 배열 만들기
		int[] arr = new int[SIZE];
		int[] arr2 = new int[SIZE];
		for (int i = 0; i < SIZE; i++) {
			int number = (int) ((Math.random() * SIZE) + 1);
			arr[i] = number;
			arr2[i] = number;
		}

		long savedTime = System.currentTimeMillis();
		sorter.sort(arr);
		System.out.println(String.format("Custom sorting에 소요된 시간 : %dms", System.currentTimeMillis() - savedTime));

		savedTime = System.currentTimeMillis();
		
		//Dual-Pivot Quick Sort
		Arrays.sort(arr2);
		System.out.println(String.format("library sorting에 소요된 시간 : %dms", System.currentTimeMillis() - savedTime));

		for (int i = 0; i < SIZE; i++) {
			if (arr[i] != arr2[i]) {
				System.out.println("Sorting was incorrect");
				return;
			}
		}
		System.out.println("Perfect sorting!");

	}

	public interface Sorter {
		public void sort(int[] arr);
	}

}
