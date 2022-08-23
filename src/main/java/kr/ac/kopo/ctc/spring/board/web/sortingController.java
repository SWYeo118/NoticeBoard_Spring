package kr.ac.kopo.ctc.spring.board.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import kr.ac.kopo.ctc.spring.board.service.BubbleSort;
import kr.ac.kopo.ctc.spring.board.service.InsertionSort;
import kr.ac.kopo.ctc.spring.board.service.SelectionSort;

public class sortingController {

	public static String filePath = "/Users/sangwoo/Desktop";
	public static String fileName = "realestatewithamenity.xlsx";

	public static void main(String[] args) {

		try {
			FileInputStream file = new FileInputStream(new File(filePath, fileName));

			// 엑셀 파일로 Workbook instance를 생성한다.
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// workbook의 첫번째 sheet를 가저온다.
			XSSFSheet sheet = workbook.getSheetAt(0);

			// 만약 특정 이름의 시트를 찾는다면 workbook.getSheet("찾는 시트의 이름");
			// 만약 모든 시트를 순회하고 싶으면
			// for(Integer sheetNum : workbook.getNumberOfSheets()) {
			// XSSFSheet sheet = workbook.getSheetAt(i);
			// }
			// 아니면 Iterator<Sheet> s = workbook.iterator() 를 사용해서 조회해도 좋다.
			
			// 정렬 알고리즘 선택
			Sorter sorter = new BubbleSort();

			// 각각 다른 방식으로 정렬할 두개의 배열 만들기
			List<Integer> arrIntBase = new ArrayList<>();
			List<Integer> arrIntCompare = new ArrayList<>();
			List<String> arrStringBase = new ArrayList<>();
			List<String> arrStringCompare = new ArrayList<>();
			
			// 모든 행(row)들을 조회한다.
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				// 각각의 행에 존재하는 모든 열(cell)을 순회한다.
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					// cell의 타입을 확인하고, 값을 가져온다.
					
					if (cell.getCellType() == CellType.NUMERIC) {
						arrIntBase.add((int) cell.getNumericCellValue());
						arrIntCompare.add((int) cell.getNumericCellValue());
					} else if (cell.getCellType() == CellType.STRING) {
						arrStringBase.add(cell.getStringCellValue());
						arrStringCompare.add(cell.getStringCellValue());
					}
					
//					switch (cell.getCellType()) {
//					case NUMERIC:
//						System.out.print((int) cell.getNumericCellValue() + "\t"); // getNumericCellValue 메서드는 기본으로 double형 반환
//						break;
//					case STRING:
//						System.out.print(cell.getStringCellValue() + "\t");
//						break;
//					}
				}
				System.out.println();
			}
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		// 정렬 시작
		// 총 배열의 길이 미리 정하기
//		final int SIZE = 30000;


//		int[] arr = new int[SIZE];
//		int[] arr2 = new int[SIZE];
		for (int i = 0; i < SIZE; i++) {
			int number = (int) ((Math.random() * SIZE) + 1);
			arr[i] = number;
			arr2[i] = number;
		}

		long savedTime = System.currentTimeMillis();
		sorter.sort(arr);
		System.out.println(String.format("Custom sorting에 소요된 시간 : %dms", System.currentTimeMillis() - savedTime));

		savedTime = System.currentTimeMillis();

		// Dual-Pivot Quick Sort
		Arrays.sort(arr2);
		System.out.println(String.format("library sorting에 소요된 시간 : %dms", System.currentTimeMillis() - savedTime));

		for (int i = 0; i < SIZE; i++) {
			if (arr[i] != arr2[i]) {
				System.out.println("Sorting was incorrect");
				return;
			}
		}
		System.out.println("Perfect sorting!");
		
		// 정렬 끝
	}

	public interface Sorter {
		public void sort(int[] arr);
	}

}
