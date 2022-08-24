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

import kr.ac.kopo.ctc.spring.board.service.BubbleSort;
import kr.ac.kopo.ctc.spring.board.service.InsertionSort;
import kr.ac.kopo.ctc.spring.board.service.SelectionSort;

@Service
public class sortingService {

	public static String filePath = "/Users/sangwoo/Desktop";
	public static String fileName = "realestatewithamenity.xlsx";

	public int[] doSort(int stringNum) throws IOException {
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
				XSSFCell cell = rows.getCell(8);
				arrIntBase[k] = (int) cell.getNumericCellValue();
				arrIntCompare[k] = (int) cell.getNumericCellValue();
			}

			// 정렬 알고리즘 선택
			Sorter sorter = new BubbleSort();
//			Sorter sorter = new InsertionSort();
//			Sorter sorter = new SelectionSort();

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
