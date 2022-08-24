package kr.ac.kopo.ctc.spring.board.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.spring.board.dto.numBack;
import kr.ac.kopo.ctc.spring.board.service.BubbleSort;
import kr.ac.kopo.ctc.spring.board.service.InsertionSort;
import kr.ac.kopo.ctc.spring.board.service.SelectionSort;

@Service
public class sortingService {

	public static String filePath = "/Users/sangwoo/Desktop";
	public static String fileName = "realestatewithamenity.xlsx";

	public static numBack doSortBubble(int stringNum) throws IOException {
		FileInputStream file = new FileInputStream(new File(filePath, fileName));

		// 엑셀 파일로 Workbook instance를 생성한다.
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// workbook의 첫번째 sheet를 가저온다.
		XSSFSheet sheet = workbook.getSheetAt(0);

		int rowCount = sheet.getPhysicalNumberOfRows();
		int[] arrIntBase = new int[rowCount];
		int[] arrIntCompare = new int[rowCount];
		numBack NumBack = new numBack();
		try {
			int k = 0;
			for (k = 1; k < rowCount; k++) {
				XSSFRow rows = sheet.getRow(k);
				XSSFCell cell = rows.getCell(stringNum);
				arrIntBase[k] = (int) cell.getNumericCellValue();
				arrIntCompare[k] = (int) cell.getNumericCellValue();
			}

			// 정렬 알고리즘 선택
			Sorter sorter = new BubbleSort();

			long savedTime = System.currentTimeMillis();
			sorter.sort(arrIntBase);
			for (int dd : arrIntBase) {
				System.out.println(dd);
			}
			long time1 = System.currentTimeMillis() - savedTime;
			System.out.println(String.format("Custom sorting에 소요된 시간 : %dms", time1));
			
			
			// Dual-Pivot Quick Sort
			savedTime = System.currentTimeMillis();
			Arrays.sort(arrIntCompare);
			long time2 = System.currentTimeMillis() - savedTime;
			System.out.println(String.format("library sorting에 소요된 시간 : %dms", time2));
			System.out.println("Perfect sorting!");
			NumBack.setArrIntCompare(arrIntCompare);
			NumBack.setTime1(time1);
			NumBack.setTime2(time2);
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		
		}
		// 정렬 끝
		return NumBack;
	}
	
	public static numBack doSortInsertion(int stringNum) throws IOException {
		FileInputStream file = new FileInputStream(new File(filePath, fileName));

		// 엑셀 파일로 Workbook instance를 생성한다.
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// workbook의 첫번째 sheet를 가저온다.
		XSSFSheet sheet = workbook.getSheetAt(0);

		int rowCount = sheet.getPhysicalNumberOfRows();
		int[] arrIntBase = new int[rowCount];
		int[] arrIntCompare = new int[rowCount];
		
		numBack NumBack = new numBack();
		try {
			int k = 0;
			for (k = 1; k < rowCount; k++) {
				XSSFRow rows = sheet.getRow(k);
				XSSFCell cell = rows.getCell(stringNum);
				arrIntBase[k] = (int) cell.getNumericCellValue();
				arrIntCompare[k] = (int) cell.getNumericCellValue();
			}

			// 정렬 알고리즘 선택
			Sorter sorter = new InsertionSort();

			long savedTime = System.currentTimeMillis();
			sorter.sort(arrIntBase);
//			for (int dd : arrIntBase) {
//				System.out.println(dd);
//			}
			long time1 = System.currentTimeMillis() - savedTime;
			System.out.println(String.format("Custom sorting에 소요된 시간 : %dms", time1));
			
			
			savedTime = System.currentTimeMillis();
			// Dual-Pivot Quick Sort
			Arrays.sort(arrIntCompare);
			long time2 = System.currentTimeMillis() - savedTime;
			System.out.println(String.format("library sorting에 소요된 시간 : %dms", time2));
			System.out.println("Perfect sorting!");
			NumBack.setArrIntCompare(arrIntCompare);
			NumBack.setTime1(time1);
			NumBack.setTime2(time2);
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 정렬 끝
		return NumBack;
	}
	
	
	public static int[] doSortSelection(int stringNum) throws IOException {
		FileInputStream file = new FileInputStream(new File(filePath, fileName));

		// 엑셀 파일로 Workbook instance를 생성한다.
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// workbook의 첫번째 sheet를 가저온다.
		XSSFSheet sheet = workbook.getSheetAt(0);

		int rowCount = sheet.getPhysicalNumberOfRows();
		int[] arrIntBase = new int[rowCount];
		int[] arrIntCompare = new int[rowCount];
		
		try {
			int k = 0;
			for (k = 1; k < rowCount; k++) {
				XSSFRow rows = sheet.getRow(k);
				XSSFCell cell = rows.getCell(stringNum);
				arrIntBase[k] = (int) cell.getNumericCellValue();
				arrIntCompare[k] = (int) cell.getNumericCellValue();
			}

			// 정렬 알고리즘 선택
			Sorter sorter = new SelectionSort();

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
//			arrIntCompare[rowCount + 1] =  (int) (System.currentTimeMillis() - savedTime);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 정렬 끝
		return arrIntCompare;
	}

	public interface Sorter {
		public void sort(int[] arrIntBase);
	}

}
