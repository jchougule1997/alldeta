package com.sn.utilities;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.ExtentReports;

public class ExtendsReportGenarator {
	
public static  ExtentReports extent;
	
	public static ExtentReports extentreprts() {
		
		String str="C:\\Users\\LENOVO\\eclipse-workspace\\SN-POC\\Reports";
		ExtentSparkReporter reporter=new ExtentSparkReporter(str);
		
		reporter.config().setDocumentTitle("service now project");
		reporter.config().setReportName("service now Report");
		reporter.config().setTheme(Theme.DARK);
		
	 extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Project Name", "Service Now");
		extent.setSystemInfo("User Name" ,"Prachi Nimje");
		extent.setSystemInfo("EmpId", "CZ109");
		extent.setSystemInfo("Environment", "Automation Testing");
		
		return 	extent;
} 

}
