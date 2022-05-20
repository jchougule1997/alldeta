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

public class ResolveInfoTest extends TestBase
{

	LoginPage loginpage;
	HomePage homepage;
	IncidentCreate incidentcreate;
	ResolveInfo resolveinfo;
	IncidentResolve incidentresolve;
	private String Caller;
	private String Shortdescription;
	String wbsheet = "ResolveNotes";
	private String shortdiscription;
	//SearchIncident searchincident;
	private String caller;
	
	/////////////////
	
	/*public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest extentTest;
	@BeforeTest
	public void setExtent(){
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/Extent.html", true);
		extent.addSystemInfo("Host Name", "Tathagat");
		extent.addSystemInfo("User Name", "cogniwize.demo@gmail.com");
		extent.addSystemInfo("Environment", "QA");
		
	}
	@AfterTest
	public void endReport(){
		extent.flush();
		extent.close();
	
	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}*/
	
	
	@BeforeMethod
	public void setup() throws InterruptedException, IOException 
	{
		launch();
		loginpage = new LoginPage();
		homepage = loginpage.LoginData(p.getProperty("un"), p.getProperty("pass"));
		//incidentcreate=homepage.SearchIncident();
		homepage = new HomePage();
		incidentcreate=homepage.SearchIncident();
		
		//resolveinfo=incidentcreate.NewIncident(caller,shortdiscription);
		//incidentcreate = new IncidentCreate(Caller, Shortdescription);
		
		//incidentcreate = new IncidentCreate();
		//resolveinfo=incidentcreate.NewIncident(Caller,Shortdescription);

		//incidentcreate=new IncidentCreate();
		//resolveinfo=new ResolveInfo();
		//Thread.sleep(3000);

		//searchincident=new SearchIncident();
		//Assert.assertEquals(loginpage.verifyLogin(), "ServiveNow", "Login failed");
	}
	
	@DataProvider
	public Iterator<Object[]> ResolveIncidents()
	{
	ArrayList<Object[]> testData=TestUtil.getDataFromExcel(wbsheet);
	return testData.iterator();
	}
	
   /* @Test(priority=1)
	public void verify() throws InterruptedException 
	{ 
		String title = resolveinfo.VerifyTitle();
		System.out.println("This is Test1");
		//System.out.println(title); Assert.assertEquals(title, "ServiceNow Developers", "Title not matched"); 
	}*/
	/*@Test(dataProvider="getResTestData")
	public void NewIncident(String Caller,String Shortdescription) throws InterruptedException
	{
		System.out.println("Executing NewIncident test case");
		//ResolveInfo = homepage.SearchIncident();
		resolveinfo=incidentcreate.NewIncident(Caller,Shortdescription);
		
	}*/
    
	@Test(dataProvider="ResolveIncidents")
	public void ResolveIncident(String caller,String shortdiscription,String ResolveNotesData) throws InterruptedException
	{
		//extentTest = extent.startTest("ResolveIncident");
		System.out.println("This is Test2");
		System.out.println("Executing NewIncident test case");
		//ResolveInfo = homepage.SearchIncident();
		resolveinfo=incidentcreate.NewIncident(caller,shortdiscription);
		//Thread.sleep(2000);
		incidentresolve=resolveinfo.ResolveIncident(caller,shortdiscription,ResolveNotesData);
		System.out.println("CallerName And ShortDiscription and ReolveNotes are" +incidentresolve);
	}

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	/*@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		
		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
			
			String screenshotPath = ResolveInfoTest.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
			//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

		}
		
		
		extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
		driver.quit();
	}
	*/
	
	

}
