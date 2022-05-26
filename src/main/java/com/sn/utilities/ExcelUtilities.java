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
	static String filePath="C:\\Users\\jalindar.chougule\\git\\SN-POCNEW\\src\\main\\java\\com\\testdata\\TestData2.xlsx";
	//static String filePath="C:\\Users\\avanti.joshi\\Documents\\GitHub\\AmazonFunctions_Testing\\Salesforce_Automation\\Sales_Cloud_Automation\\src\\test\\java\\resources\\TestData..xlsx";


//	static XSSFWorkbook workbook;
//	static XSSFSheet sheet;
//	public static Object[][] getExcel(String wbsheet) throws IOException   {
//		FileInputStream file=null;
//		try{
//			file=new FileInputStream(filePath);
//		}catch(FileNotFoundException e){
//			e.printStackTrace();
//		}
//		try {
//			workbook=new XSSFWorkbook(file);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		sheet=workbook.getSheet(wbsheet);
//
//		//Using FOR Loop to read Row
//		int rows=sheet.getLastRowNum();
//		int cols=sheet.getRow(0).getLastCellNum();
//
//		Object[][] obj=new Object[rows][cols];
//
//		for(int r=0;r<rows;r++) {
//			for(int c=0;c<cols;c++) {
//				obj[r][c]=sheet.getRow(r+1).getCell(c).toString();
//				//	System.out.println(obj[r][c]);
//			}
//		}
//		return obj;
//	}

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
			// System.out.println(sheet.getLastRowNum() + "--------" +
			// sheet.getRow(0).getLastCellNum());
			for (int i = 0; i < (sheet).getLastRowNum(); i++) {
				for (int k = 0; k < (sheet).getRow(0).getLastCellNum(); k++) {
					data[i][k] = (sheet).getRow(i + 1).getCell(k).toString();
				//	System.out.println(data[i][k]);
				}
			}
			return data;
		}
	

}
