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
	public static String fileName = "population.xlsx";

	public static numBack doSortBubble(int stringNum) throws IOException {
		FileInputStream file = new FileInputStream(new File(filePath, fileName));

		XSSFWorkbook workbook = new XSSFWorkbook(file);
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
			
			// 버블정렬
			long savedTime = System.currentTimeMillis();
			sorter.sort(arrIntBase);
			long time1 = System.currentTimeMillis() - savedTime;
			for (int dd : arrIntBase) {
				System.out.println(dd);
			}

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
//			NumBack.setBubbleSort(sorter);
			file.close();
		} catch (IOException e) {
			e.printStackTrace();

		}
		// 정렬 끝
		return NumBack;
	}

	public static numBack doSortInsertion(int stringNum) throws IOException {
		FileInputStream file = new FileInputStream(new File(filePath, fileName));

		XSSFWorkbook workbook = new XSSFWorkbook(file);
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

	public static numBack doSortSelection(int stringNum) throws IOException {
		FileInputStream file = new FileInputStream(new File(filePath, fileName));

		XSSFWorkbook workbook = new XSSFWorkbook(file);
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
			Sorter sorter = new SelectionSort();

			long savedTime = System.currentTimeMillis();
			sorter.sort(arrIntBase);
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

	public interface Sorter {
		public void sort(int[] arrIntBase);
	}

}
