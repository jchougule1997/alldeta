package com.sn.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;


public class ExcelUtilities {
	static String filePath= "C:\\Users\\LENOVO\\eclipse-workspace\\SN-POC\\src\\main\\java\\com\\sn\\resources\\TestData.xlsx";
	//static String wbsheet="IncidentData";
	//static String filePath=System.getProperty("user.dir")+"/SN-POC/src/main/java/com/sn/resources/TestData.xlsx";
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

		
		
		/*public void setXLCellValue(String sheetName,int rowNum,int cellNum, String input)
		{
		    try{
		        FileInputStream fis=new FileInputStream(filePath);

		        Workbook wb=WorkbookFactory.create(fis);

		        wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(input);

		        FileOutputStream fos=new FileOutputStream(filePath);

		        wb.write(fos);

		        fos.close();

		    }
		    catch(Exception ex)
		    {

		    }*/

		
		/*
		 * public static void writeexcel(String sheetname) { sheet = (Sheet)
		 * book.getSheet(sheetname); sheet.getRow(0).createCell(2).setCellValue();
		 * 
		 * try { FileOutputStream fos = new FileOutputStream(filePath); book.write(fos);
		 * }catch(Exception e) { e.printStackTrace(); } return ; }
		 */
	
}
