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
import com.sn.Pages.CreateVIPIncident;
import com.sn.Pages.HomePage;
import com.sn.Pages.LoginPage;
import com.sn.utilities.TestUtil;

public class CreateVIPIncidentTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	CreateVIPIncident Createvipincident;

	static String wbsheet = "VIPIncidentData";

	public CreateVIPIncidentTest() {

		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		launch();
		loginpage = new LoginPage();
		driver.switchTo().frame(0);
		homepage = loginpage.LoginData(p.getProperty("un"), p.getProperty("pass"));
		Createvipincident = homepage.SearchIncident();
	}

	@DataProvider
	public Iterator<Object[]> getIncidentData() {
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel(wbsheet);
		return testData.iterator();

	}

	@Test(dataProvider = "getIncidentData")
	public void createVIPIncident(String Caller, String Shortdescription) throws InterruptedException {
		Createvipincident.ClickonNewButton();

		Createvipincident.VIPIncident(Caller, Shortdescription);

		String actualTitle = Createvipincident.verifyIncidentPage();

		String expectedtitle = "Incidents [Portal view] | ServiceNow";

		Assert.assertEquals(actualTitle, expectedtitle, "The Title is not match,assert is failed");

		System.out.println("The Actual Title is  : " + actualTitle);

	}

	@AfterMethod

	public void close_Browser() {
		driver.quit();
	}

}