package com.sn.Testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

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

public class IncidentCreateTest extends TestBase {

	LoginPage loginpage;

	HomePage homepage;

	IncidentCreate incidentcreate;

	static String wbsheet = "IncidentData";

	public IncidentCreateTest() {
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
	public Iterator<Object[]> getIncidentData() {
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel(wbsheet);

		return testData.iterator();

	}

	@Test(dataProvider = "getIncidentData")
	public void createIncident(String Caller, String Shortdescription) throws InterruptedException {
		incidentcreate.ClickonNewButton();

		incidentcreate.CreateNewIncident(Caller, Shortdescription);

		String name = incidentcreate.verifyIncidentPage();

		System.out.println(name);

		Assert.assertEquals(name, "Incidents [Portal view]", "Incident not created");

	}

	@AfterMethod

	public void teardown() {
		driver.quit();
	}

}
