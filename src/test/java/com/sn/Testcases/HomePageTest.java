package com.sn.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sn.Commons.TestBase;
import com.sn.Pages.HomePage;
import com.sn.Pages.IncidentCreate;
import com.sn.Pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginpage;

	HomePage homepage;

	IncidentCreate incidentcreate;

	@BeforeMethod

	public void setup() throws InterruptedException {

		launch();

		loginpage = new LoginPage();

		driver.switchTo().frame(0);

		homepage = loginpage.LoginData(p.getProperty("un"), p.getProperty("pass"));

	}

	@Test
	public void SearchIncident() throws InterruptedException {
		System.out.println("Executing SearchIncident test case");

		incidentcreate = homepage.SearchIncident();
	}

	@AfterMethod

	public void teardown() {
		driver.quit();
	}

}
