package com.sn.utilities;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendsReportGenarator {

	public static ExtentReports extent;

	public static ExtentReports extentreprts() {

		String str = "C:\\Users\\jalindar.chougule\\git\\SN-POCNEW\\Reports";

		ExtentSparkReporter reporter = new ExtentSparkReporter(str);

		reporter.config().setDocumentTitle("service now project");

		reporter.config().setReportName("service now Report");

		reporter.config().setTheme(Theme.DARK);

		ExtentReports extent = new ExtentReports();

		extent.attachReporter(reporter);

		extent.setSystemInfo("Project Name", "Service Now");

		extent.setSystemInfo("User Name", "Jalindar Chougule");

		extent.setSystemInfo("EmpId", "CZ110");

		extent.setSystemInfo("Environment", "Automation Testing");

		extent.setSystemInfo("State Demo", " All State is Passed");

		return extent;
	}
}