package com.sn.Testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sn.Commons.TestBase;
import com.sn.Pages.HomePage;
import com.sn.Pages.LoginPage;
import junit.framework.Assert;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() throws IOException {
		super();
	}

	@BeforeMethod()
	public void setup() throws Exception {
		launch();
		loginPage = new LoginPage();
		homePage = new HomePage();

	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "ServiceNow");
	}

	@Test(priority = 3)
	public void loginPageTest() throws InterruptedException {

		driver.switchTo().frame(0);
		homePage = loginPage.LoginData(p.getProperty("un"), p.getProperty("pass"));

	}

	@AfterMethod()
	public void TearDown() {
		driver.close();
	}

}
