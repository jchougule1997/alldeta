package com.sn.utilities;

import java.util.ArrayList;

public class TestUtil {

	static Xls_Reader reader;

	public static ArrayList<Object[]> getDataFromExcel(String Sheetname) {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try {
			// reader = new Xls_Reader(
			// "C:\\Users\\jalindar.chougule\\git\\Service_NowProject\\src\\main\\java\\com\\sn\\resources\\TestData.xlsx");
			reader = new Xls_Reader(
					"C:\\Users\\jalindar.chougule\\git\\Service_NowProject\\src\\main\\java\\com\\sn\\resources\\TestData1.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int rowNum = 2; rowNum <= reader.getRowCount(Sheetname); rowNum++) {
			if (Sheetname.equals("VIPIncidentData")) {
				String Caller = reader.getCellData("VIPIncidentData", "Caller", rowNum);
				System.out.println(Caller);
				String Shortdescription = reader.getCellData("VIPIncidentData", "Shortdescription", rowNum);
				System.out.println(Shortdescription);

				Object ob[] = { Caller, Shortdescription };
				myData.add(ob);
			}

		}
		return myData;

	}

}