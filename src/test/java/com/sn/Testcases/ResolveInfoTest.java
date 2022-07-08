package com.sn.Testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sn.Commons.TestBase;
import com.sn.Pages.HomePage;
import com.sn.Pages.IncidentCreate;
import com.sn.Pages.IncidentResolve;
import com.sn.Pages.LoginPage;
import com.sn.Pages.ResolveInfo;
import com.sn.utilities.TestUtil;

public class ResolveInfoTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	IncidentCreate incidentcreate;
	ResolveInfo resolveinfo;
	IncidentResolve incidentresolve;
	private String Caller;
	private String Shortdescription;
	String wbsheet = "ResolveNotes";
	private String shortdiscription;
	// SearchIncident searchincident;
	private String caller;

	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		launch();
		loginpage = new LoginPage();
		driver.switchTo().frame(0);
		homepage = loginpage.LoginData(p.getProperty("un"), p.getProperty("pass"));
		homepage = new HomePage();
		incidentcreate = homepage.SearchIncident();

	}

	@DataProvider
	public Iterator<Object[]> ResolveIncidents() {
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel(wbsheet);
		return testData.iterator();
	}

	@Test(dataProvider = "ResolveIncidents")
	public void ResolveIncident(String caller, String shortdiscription, String ResolveNotesData)
			throws InterruptedException {

		System.out.println("This is Test2");

		System.out.println("Executing NewIncident test case");

		resolveinfo = incidentcreate.NewIncident(caller, shortdiscription);

		System.out.println("test case of onhold data is run   ********************");

		resolveinfo.onHold();

		incidentresolve = resolveinfo.ResolveIncident(caller, shortdiscription, ResolveNotesData);

		System.out.println("CallerName And ShortDiscription and ReolveNotes are" + incidentresolve);

		System.out.println("test case of close state is run  **************");
		
		
		
		//resolveinfo.close();

		// System.out.println("test case of canceldata is run ****************");

		// resolveinfo.cancelData();

	}


	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
