package kr.ac.kopo.ctc.spring.board.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
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
			int k = 0;
			FileInputStream file = new FileInputStream(new File(filePath, fileName));

			// 엑셀 파일로 Workbook instance를 생성한다.
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// workbook의 첫번째 sheet를 가저온다.
			XSSFSheet sheet = workbook.getSheetAt(0);

			int rowCount = sheet.getPhysicalNumberOfRows();
			int[] arrIntBase = new int[rowCount];
			int[] arrIntCompare = new int[rowCount];

			for (k = 1; k < rowCount; k++) {
				XSSFRow rows = sheet.getRow(k);
				XSSFCell cell = rows.getCell(8);
				arrIntBase[k] = (int) cell.getNumericCellValue();
				arrIntCompare[k] = (int) cell.getNumericCellValue();
				System.out.println((int) cell.getNumericCellValue()); // getNumericCellValue 메서드는 기본으로 double형 반환
			}

//			int cellCount = rows.getPhysicalNumberOfCells();
//			int countOfAllCells = rowCount * cellCount;

			// 만약 특정 이름의 시트를 찾는다면 workbook.getSheet("찾는 시트의 이름");
			// 만약 모든 시트를 순회하고 싶으면
			// for(Integer sheetNum : workbook.getNumberOfSheets()) {
			// XSSFSheet sheet = workbook.getSheetAt(i);
			// }
			// 아니면 Iterator<Sheet> s = workbook.iterator() 를 사용해서 조회해도 좋다.

			// 정렬 알고리즘 선택
			Sorter sorter = new BubbleSort();
			Sorter sorter = new InsertionSort();
			Sorter sorter = new SelectionSort();

			// 각각 다른 방식으로 정렬할 두개의 배열 만들기
//			String[] arrStringBase = new String[rowCount];
//			String[] arrStringCompare = new String[rowCount];

			// 모든 행(row)들을 조회한다.
//			Iterator<Row> rowIterator = sheet.iterator();
//			while (rowIterator.hasNext()) {
//				Row row = rowIterator.next();
//				// 각각의 행에 존재하는 모든 열(cell)을 순회한다.
//				Iterator<Cell> cellIterator = row.cellIterator();
//				while (cellIterator.hasNext()) {
//					Cell cell = cellIterator.next();
//					switch (cell.getCellType()) {
//					case NUMERIC:
//						arrIntBase[i] = (int) cell.getNumericCellValue();
//						arrIntCompare[i] = (int) cell.getNumericCellValue();
//						System.out.print((int) cell.getNumericCellValue() + "\t"); // getNumericCellValue 메서드는 기본으로 double형 반환
//						i++;
//						break;
//					case STRING:
//						arrStringBase[k] = cell.getStringCellValue();
//						arrStringCompare[k] = cell.getStringCellValue();
//						System.out.print(cell.getStringCellValue() + "\t");
//						k++;
//						break;
//					}
			// cell의 타입을 확인하고, 값을 가져온다.
//					if (cell.getCellType() == CellType.NUMERIC) {
//						for (int i = 0; i < rowCount; i++) {
////							arrIntBase[i] = (int) cell.getNumericCellValue();
////							arrIntCompare[i] = (int) cell.getNumericCellValue();
//							System.out.print((int) cell.getNumericCellValue() + "\t");
//						}
//					} else if (cell.getCellType() == CellType.STRING) {
//						for (int i = 0; i < rowCount; i++) {
////							arrStringBase[i] = cell.getStringCellValue();
////							arrStringCompare[i] = cell.getStringCellValue();
//							System.out.print(cell.getStringCellValue() + "\t");
//						}
//					}

			long savedTime = System.currentTimeMillis();
			sorter.sort(arrIntBase);
			for (int dd : arrIntBase) {
				System.out.println(dd);
			}
			System.out.println(String.format("Custom sorting에 소요된 시간 : %dms", System.currentTimeMillis() - savedTime));
			savedTime = System.currentTimeMillis();
			// Dual-Pivot Quick Sort
			Arrays.sort(arrIntCompare);
			System.out.println(String.format("library sorting에 소요된 시간 : %dms", System.currentTimeMillis() - savedTime));
			System.out.println("Perfect sorting!");
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 정렬 끝
	}

	public interface Sorter {
		public void sort(int[] arrIntBase);
	}

}
