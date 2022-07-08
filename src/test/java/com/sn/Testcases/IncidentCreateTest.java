package com.sn.Testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sn.Commons.TestBase;
import com.sn.Pages.HomePage;
import com.sn.Pages.IncidentCreate;
import com.sn.Pages.LoginPage;
import com.sn.Pages.ResolveInfo;
import com.sn.utilities.TestUtil;

public class IncidentCreateTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	IncidentCreate incidentcreate;
	ResolveInfo resolveinfo;
	// SearchIncident searchincident;
	static String wbsheet = "IncidentData";

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
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel(wbsheet);
		return testData.iterator();

	}

	@Test(dataProvider = "getTestData")
	public void NewIncident(String caller, String shortdiscription) throws InterruptedException {
		if (caller.isBlank() || shortdiscription.isBlank()) {
			System.out.println("Invalid data is choosen");
			incidentcreate.InvalidIncidentcreate(caller, shortdiscription);

		} else {
			System.out.println("**********Executing new  Incident methode**********");
			resolveinfo = incidentcreate.NewIncident(caller, shortdiscription);
			String name = incidentcreate.verifyIncidentPage();
			System.out.println("This is Text of Incident create page :" + name);

		}

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
