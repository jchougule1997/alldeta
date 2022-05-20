package com.sn.utilities;

import java.util.ArrayList;

public class TestUtil
{
	
	static Xls_Reader reader;
	public static ArrayList<Object[]> getDataFromExcel(String Sheetname)
	{
		ArrayList<Object[]> myData=new ArrayList<Object[]>();
		try 
		{
			reader=new Xls_Reader("C:\\Users\\Tathagat\\eclipse-workspace\\SN-POC\\src\\main\\java\\com\\testdata\\TestData2.xlsx");
			reader.addColumn("IncidentData","status");
			reader.addColumn("ResolveNotes","Status");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		for(int rowNum=2;rowNum<=reader.getRowCount(Sheetname);rowNum++)
		{
			/*String caller=reader.getCellData("IncidentData","caller",rowNum);
			System.out.println(caller);
			String Shortdiscription=reader.getCellData("IncidentData","Shortdiscription",rowNum);
			System.out.println(Shortdiscription);
			//reader.setCellData("IncidentData","status", rowNum, "Pass");
			Object ob[]= {caller, Shortdiscription};
			myData.add(ob);*/
			if(Sheetname.equals("IncidentData") )
			{
			String caller=reader.getCellData("IncidentData","caller",rowNum);
			System.out.println(caller);
			String shortdiscription=reader.getCellData("IncidentData","shortdiscription",rowNum);
			System.out.println(shortdiscription);
			reader.setCellData("IncidentData","status", rowNum, "Pass");
			Object ob[]= {caller, shortdiscription};
			myData.add(ob);
			}
			else
			{
			String caller=reader.getCellData("ResolveNotes","caller",rowNum);
			String shortdiscription=reader.getCellData("ResolveNotes","shortdiscription",rowNum);
			String ResolveNotesData=reader.getCellData("ResolveNotes","ResolveNotesData",rowNum);
			
			System.out.println(ResolveNotesData);
			//String ChildShortdescription=reader.getCellData("IncidentData","childshortdescr",rowNum);
			//System.out.println(ChildShortdescription);
			reader.setCellData("ResolveNotes","Status", rowNum, "Pass");
			Object ob2[]= {caller,shortdiscription,ResolveNotesData};
			myData.add(ob2);
			}
			
		}
		return myData;
		
	}
	

}

