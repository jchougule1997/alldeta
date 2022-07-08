package com.sn.utilities;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.*;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.openxml4j.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilities {

	static String filePath = "C:\\Users\\jalindar.chougule\\git\\SN-POCNEW\\src\\main\\java\\com\\testdata\\TestData2.xlsx";

	static Workbook book;

	static Sheet sheet;

	static JavascriptExecutor js;

	public static Object[][] getExcel(String sheetName) {

		FileInputStream file = null;

		try {
			file = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = (Sheet) book.getSheet(sheetName);

		Object[][] data = new Object[(sheet).getLastRowNum()][(sheet).getRow(0).getLastCellNum()];

		for (int i = 0; i < (sheet).getLastRowNum(); i++) {

			for (int k = 0; k < (sheet).getRow(0).getLastCellNum(); k++) {

				data[i][k] = (sheet).getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}

}
