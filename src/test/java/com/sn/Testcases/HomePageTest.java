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
	public void setup() throws InterruptedException, IOException 
	{
		launch();
		loginpage = new LoginPage();
		homepage = loginpage.LoginData(p.getProperty("un"), p.getProperty("pass"));
		//incidentcreate = new IncidentCreate();
		//homepage = new HomePage();
		//Assert.assertEquals(loginpage.verifyLogin(), "ServiveNow", "Login failed");
	}
	
	/*@DataProvider
	
	public Iterator<Object[]> getTestData(){
	//ArrayList<Object[]> testData1=TestUtil.getDataFromExcel();
	ArrayList<Object[]> testData1= IncidentUtil.getDataFromExcel1();
	return testData1.iterator();
	
	}*/
	
	
	@Test(priority=1) 
	 public void verify() throws InterruptedException 
	 { 
	  String title = homepage.VerifyTitle(); 
	  //Assert.assertEquals(homepage, "com.sn.Pages.HomePage@36b6964d", "Title not matched");
	  //Thread.sleep(5000);
	  //System.out.println(title); Assert.assertEquals(title, "ServiceNow Developers", "Title not matched"); 
	  }
	 
	@Test(priority=2)
	public void SearchIncident() throws InterruptedException
	{
		System.out.println("Executing SearchIncident test case");
		incidentcreate = homepage.SearchIncident();
		//System.out.println(incidentcreate);
	}
	
//	@AfterMethod
//	public void teardown()
//	{
//		driver.quit();
//	}
//	@AfterMethod
//	public void tearDown(ITestResult result) throws IOException {
//	    String location = "currentDir + \"/screenshots/\" + System.currentTimeMillis() + \".png\"";  //location for images
//	    String methodname = result.getName(); // fetching test method name
//	    try {
//	        File screenshots = ((TakesScreenshot) driver)
//	                               .getScreenshotAs(OutputType.FILE);
//	        FileUtils.copyFile(	            screenshots,
//	            new File(location + methodname + "_" + ".png");
//	    } catch (Exception e) {
//	          e.printStackTrace();
//	    } finally {
//	          driver.quit();
//	    }
	    @AfterMethod()
		public static void takeScreenshotAtEndOfTest(ITestResult result) throws IOException {
	    	
	    	 String methodname = result.getName(); // fetching test method name
	    	//String className= result.getClass().getName();
	    	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    	String currentDir = System.getProperty("user.dir");
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/"+ methodname +"_"+ System.currentTimeMillis() + ".png"));
			driver.quit();
		}
}
