package com.sn.Testcases;

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
import com.sn.utilities.ExcelUtilities;
import com.sn.utilities.TestUtil;

public class ChildIncidentTest extends TestBase {

	LoginPage loginpage;

	HomePage homepage;

	IncidentCreate incidentcreate;

	String wbsheet = "ChildIncidentData";

	public ChildIncidentTest() {
		super();
	}

	@BeforeMethod

	public void setup() throws InterruptedException {
		launch();

		loginpage = new LoginPage();

		driver.switchTo().frame(0);

		homepage = loginpage.LoginData(p.getProperty("un"), p.getProperty("pass"));

		incidentcreate = homepage.SearchIncident();

	}

	@DataProvider
	public Iterator<Object[]> getchildincidentdata() {

		ArrayList<Object[]> testData = TestUtil.getDataFromExcel(wbsheet);

		return testData.iterator();

	}

	@Test(dataProvider = "getchildincidentdata")

	public void createchildincident(String Caller, String Shortdescription, String Childcaller,
			String ChildShortdescription) throws InterruptedException {

		incidentcreate.ClickonNewButton();

		incidentcreate.CreateNewIncident(Caller, Shortdescription);

		incidentcreate.ClickonChildIncident();

		incidentcreate.CreatechildIncident(Childcaller, ChildShortdescription);

	}

	@AfterMethod

	public void teardown() {

		if (driver != null) {

			driver.quit();
		}
	}
}
