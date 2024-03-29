package kr.ac.kopo.ctc.spring.board.service;

import kr.ac.kopo.ctc.spring.board.web.sortingService.Sorter;

public class QuickSortRightPivot implements Sorter {

	@Override
	public void sort(int[] arr) {
		rPivotSort(arr, 0, arr.length - 1);
	}

	private static void rPivotSort(int[] arr, int low, int high) {

		if (low >= high) {
			return;
		}
		int pivot = partition(arr, low, high);

		rPivotSort(arr, low, pivot - 1);
		rPivotSort(arr, pivot + 1, high);
	}

	private static int partition(int[] arr, int left, int right) {
		int low = left;
		int high = right;
		int pivot = arr[right];

		while (low < high) {
			while (arr[low] < pivot && low < high) {
				low++;
			}
			while (arr[high] >= pivot && low < high) {
				high--;
			}

			swap(arr, low, high);
		}

		swap(arr, right, high);
		return high;
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
