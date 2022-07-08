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
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sn.Commons.TestBase;
import com.sn.Pages.HomePage;
import com.sn.Pages.IncidentCreate;
import com.sn.Pages.LoginPage;
import com.sn.utilities.IncidentUtil;
import com.sn.utilities.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	IncidentCreate incidentcreate;

	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		launch();
		loginpage = new LoginPage();
		driver.switchTo().frame(0);
		homepage = loginpage.LoginData(p.getProperty("un"), p.getProperty("pass"));

	}

	@Test(priority = 1)
	public void verify() throws InterruptedException {
		String title = homepage.VerifyTitle();
		System.out.println("Home page Title is" + title);
		Assert.assertEquals(title, "ServiceNow", "Title not matched");

		String exp = "ServiceNow";
		if (title.equalsIgnoreCase(exp)) {
			System.out.println("successfully loged in & opened home page");
		} else {
			System.out.println("successfully loged in but Not opened home page ");

		}

	}

	@Test(priority = 2)
	public void SearchIncident() throws InterruptedException {
		System.out.println("Executing SearchIncident test case");
		incidentcreate = homepage.SearchIncident();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
