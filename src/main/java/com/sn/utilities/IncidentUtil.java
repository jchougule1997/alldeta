package com.sn.utilities;

import java.util.ArrayList;

public class IncidentUtil {

	static Xls_Reader reader;

	public static ArrayList<Object[]> getDataFromExcel1() {
		ArrayList<Object[]> myData1 = new ArrayList<Object[]>();
		try {
			reader = new Xls_Reader(
					"C:\\Users\\jalindar.chougule\\git\\SN-POCNEW\\src\\main\\java\\com\\testdata\\TestData2.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int rowNum = 2; rowNum <= reader.getRowCount("TypeIncident"); rowNum++) {
			String FilterNavigator = reader.getCellData("TypeIncident", "FilterNavigator", rowNum);
			System.out.println(FilterNavigator);

			Object ob[] = { FilterNavigator };
			myData1.add(ob);
		}
		return myData1;

	}

}
